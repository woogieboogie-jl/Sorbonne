import java.lang.Math.*;

public class Cone{
	private double r;
	private double h;
	private final double PI = 3.14159;
	static int nbCones;

	public Cone(double r, double h){
		this.r = r;
		this.h = h;
		nbCones += 1;
	}

	public Cone(){
		this.r = Math.random()*10;
		this.h = Math.random()*10;
		nbCones += 1;
	}
	
	public double getVolume(){
		return PI*(this.r)*(this.r)*(this.h)/3;
	}
	
	public String toString(){
		return "Cone r=" + String.format("%f", this.r) + " h=" + String.format("%f",this.h) + " v=" + String.format("%f", this.getVolume()); 
	}
	
	public static int getnbCones(){
		return nbCones;
	}
}
