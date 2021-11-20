public class Ellipse extends Figure2D{
	protected double a;
	protected double b;

	public Ellipse(double a, double b){
		this.a = a;
		this.b = b;
	}

	public Ellipse(){
		this.a = Math.random()*10;
		this.b = Math.random()*10;
	}

	public double perimetre(){
		return ( 2*Math.PI * Math.sqrt( (a*a + b*b)/2 ) );
	}

	public double surface(){
		return ( Math.PI*a*b );
	}

	public String toString(){ return "Ellipse"; }
}
