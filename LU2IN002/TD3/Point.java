import static java.lang.Math.*;

public class Point{
	private double x,y;
	public Point(){
		x = Math.random();
		y = Math.random();
	}
	public void bouger() {
		x = Math.random();
		y = Math.random();
	}
	public double getPosX(){
		return this.x;
	}
	public double getPosY(){
		return this.y;
	}
}
