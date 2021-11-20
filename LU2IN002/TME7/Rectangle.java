import java.lang.Math.*;

public class Rectangle extends Figure2D{
	protected double h;
	protected double l;

	public Rectangle(double h, double l){
		this.h = h;
		this.l = l;
	}

	public Rectangle(){
		this.h = Math.random()*10;
		this.l = Math.random()*10;
	}

	public double perimetre(){
		return 2*(h+l);
	}

	public double surface(){
		return h*l;
	}

	public String toString() { return "rectangle"; }
}
