import java.lang.Math.*;

public class Complexe{
	double reelle;
	double imag;

	public Complexe(double reelle, double imag){
		this.reelle = reelle;
		this.imag = imag;
	}

	public Complexe(){
		this((Math.random()*4 -2), (Math.random()*4 -2));
	}

	public String toString(){
		return String.format("%.2f", reelle) + " + " + String.format("%.2f", imag) + " i";
	}
	
	public boolean estReel(){
		if (imag == 0) { return true; } else { return false; } 
	}

	public Complexe addition(Complexe c){
		return new Complexe((this.reelle + c.reelle), (this.imag + c.imag));
	}

	public Complexe multiplication(Complexe c){
		return new Complexe( (this.reelle*c.reelle - this.imag*c.imag), (this.reelle*c.imag + this.imag*c.reelle) );
	}

}


