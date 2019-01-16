import java.util.ArrayList;
public class Snake {
//	snake is an arraylist of type box 
	private ArrayList<Box> snakeArray = new ArrayList<>();
	private static int score = 0;
	public Snake(){
		snakeArray.add(new Box(20, 0, 10, "right"));
		snakeArray.add(new Box(10, 0, 10, "right"));
		snakeArray.add(new Box(0, 0, 10, "right"));
		
	}
	public Box getBox(int index){
		return snakeArray.get(index);
	}
	public static int getScore(){
		return score;
	}
	public int size(){
		return snakeArray.size();
	}
//	this method is called by timer and is effected by the keylistener
	public void moveSnake() {
		String headDirection = snakeArray.get(0).getDirection();
//		looks to see if the snake has run into the food if it has it will grow in length increase the score and create a new instance of food
		if(snakeArray.get(0).getX()==Food.getBox().getX()&&snakeArray.get(0).getY()==Food.getBox().getY()){
			Sound.play("Pickup_Coin.wav");
			score=score+100;
			System.out.println(score);
			if(headDirection.equals("right")){
				snakeArray.add(0, new Box(snakeArray.get(0).getX()+10, snakeArray.get(0).getY(), snakeArray.get(0).getWidth(), "right"));
			}
			if(headDirection.equals("left")){
				snakeArray.add(0, new Box(snakeArray.get(0).getX()-10, snakeArray.get(0).getY(), snakeArray.get(0).getWidth(), "left"));
			}
			if(headDirection.equals("up")){
				snakeArray.add(0, new Box(snakeArray.get(0).getX(), snakeArray.get(0).getY()-10, snakeArray.get(0).getWidth(), "up"));
			}	
			if(headDirection.equals("down")){
				snakeArray.add(0, new Box(snakeArray.get(0).getX(), snakeArray.get(0).getY()+10, snakeArray.get(0).getWidth(), "down"));
			}
			Food.newFood();
			for(int i = 0; i<snakeArray.size();i++){
				if(Food.getBox().getX()!=snakeArray.get(i).getX()&&Food.getBox().getY()!=snakeArray.get(i).getY()){
					break;
				}
				else{
					Food.newFood();
					i=0;
				}
			}
			
		}
//		deletes the trailing instance of the snake and adds one to the head 
		else{
			if(headDirection.equals("right")){
				snakeArray.remove(snakeArray.size()-1);
				snakeArray.add(0, new Box(snakeArray.get(0).getX()+10, snakeArray.get(0).getY(), snakeArray.get(0).getWidth(), "right"));
			}
			if(headDirection.equals("left")){
				snakeArray.remove(snakeArray.size()-1);
				snakeArray.add(0, new Box(snakeArray.get(0).getX()-10, snakeArray.get(0).getY(), snakeArray.get(0).getWidth(), "left"));
			}
			if(headDirection.equals("up")){
					snakeArray.remove(snakeArray.size()-1);
						snakeArray.add(0, new Box(snakeArray.get(0).getX(), snakeArray.get(0).getY()-10, snakeArray.get(0).getWidth(), "up"));
			}	
			if(headDirection.equals("down")){
					snakeArray.remove(snakeArray.size()-1);
					snakeArray.add(0, new Box(snakeArray.get(0).getX(), snakeArray.get(0).getY()+10, snakeArray.get(0).getWidth(), "down"));
			}
			
		}
//		checks for end game scenarios as well as wining scenario
		if(snakeArray.get(0).getX()>980||snakeArray.get(0).getX()<0||snakeArray.get(0).getY()<0||snakeArray.get(0).getY()>970){
				Screen.GameOver();
			}
		if(snakeArray.size()==10000){
				Screen.WinGame();
		}
		for(int i =1; i<snakeArray.size(); i++){
			if(snakeArray.get(0).getX()==snakeArray.get(i).getX()&&snakeArray.get(0).getY()==snakeArray.get(i).getY()){
				Screen.GameOver();
			}
		}
	}
}
