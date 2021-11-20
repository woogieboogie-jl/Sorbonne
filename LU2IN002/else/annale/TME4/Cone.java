import java.lang.Math.*;

public class Cone{
	private double r;
	private double h;
	private static final double PI = 3.14159;
	private static int nbCones = 0;
	
	public Cone(double r, double h){
		this.r = r;
		this.h = h;
		nbCones += 1;
	}

	public Cone(){
		this(Math.random()*10, Math.random()*10);
	}

	public double getVolume(){
		return ((PI)*(r*r)*(h)/3);
	}

	public String toString(){
		return "Cone r=" + String.format("%.1f", r) + " h=" + String.format("%.1f", h) + " V=" + String.format("%.1f", this.getVolume());
	}

	public static int nbCones(){ return nbCones; }

}

