import java.lang.Math.*;

public class Carre extends Rectangle{
	public Carre(double c){
		super(c,c);
	}

	public Carre(){
		super();
		this.l = this.h;
	}

	public String toString(){ return "Carre"; }
}
