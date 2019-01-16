import java.util.Random;
public class Food {
//	uses box class to make food for the game
	private static Box edibleBox;
	private static Random x = new Random();
	private static Random y = new Random();
	public Food(){
		edibleBox = new Box(400, 400, 10);
	}
	public static Box getBox(){
		return edibleBox;
	}
//	creates a new food randomly on the screen
	public static void newFood(){
		edibleBox = new Box(x.nextInt(98)*10,y.nextInt(97)*10,10);
	}
}
