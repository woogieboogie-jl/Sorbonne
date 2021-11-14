import java.lang.Math.*;

public class Point{
	private int posx;
	private int posy;
	public Point(){
		this.posx = (int)(Math.random() * 10);
		this.posy = (int)(Math.random() * 10);
	}
	public Point(int posx, int posy){
		this.posx = posx;
		this.posy = posy;
	}

	public void setPosx(int posx){
		this.posx = posx;
	}
	public void setPosy(int posy){
		this.posy = posy;
	}
	public int getPosx(){
		return this.posx;
	}
	public int getPosy(){
		return this.posy;
	}

	public String toString(){
		return "(" + String.format("%d", this.getPosx()) + ", "+ String.format("%d", this.getPosy()) + ")";
	}

	public double distance(Point p){
		return Math.sqrt((p.getPosx() - this.getPosx())*(p.getPosx() - this.getPosx()) + (p.getPosy() - this.getPosy()) * (p.getPosy() - this.getPosy()));
	}
	public void replacePoint(int posx, int posy){
		this.posx = posx;
		this.posy = posy;
	}
}
