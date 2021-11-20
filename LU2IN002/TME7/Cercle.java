public class Cercle extends Ellipse{
	public Cercle(double r){
		super(r,r);
	}
	public Cercle(){
		super();
		this.a = this.b;
	}

	public String toString(){ return "Cercle"; }
}
