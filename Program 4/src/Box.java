import java.awt.Color;
public class Box {
//	this class serves as a base for snake and food
	private int x;
	private int y;
	private int width;
	private String direction = "right"; 
	public void changeDirection(String newDirection){
		direction= newDirection; 
	}
	public String getDirection(){
		return direction;
	}
	public Box(int xcoord, int ycoord, int dimension, String Dir){
		x=xcoord;
		y=ycoord;
		width=dimension;
		direction=Dir;
	}
	public Box(int xcoord, int ycoord, int dimension){
		x=xcoord;
		y=ycoord;
		width=dimension;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
}
