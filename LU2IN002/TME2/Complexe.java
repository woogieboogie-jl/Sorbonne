import java.lang.Math.*;

public class Complexe{
	private double reelle;
	private double imag;
	

	public Complexe(double reelle,double imag){
		this.reelle = reelle;
		this.imag = imag;
	}
	

	public Complexe(){
		this.reelle = (double)(Math.random() * 4) + -2;
		this.imag = (double)(Math.random() * 4) + -2;
	}

	public double getReelle(){
		return this.reelle;
	}

	public double getImag(){
		return this.imag;
	}

	public String toString(){
		if (this.getReelle()==0 && this.getImag()==0){
			return "0";
		} else if (this.getReelle()==0 && this.getImag()!=0){
			return String.format("%.2f", this.getImag())+"i";
		} else if (this.getReelle()!=0 && this.getImag()==0){
			return String.format("%.2f", this.getReelle());
		} else {
			return "(" + String.format("%.2f", this.getReelle()) + " + " + String.format("%.2f", this.getImag()) + "i" + ")";
		}
	}

	public boolean estReel(){
		if (this.getImag() == 0){
			return true;
		}else{
			return false;
		}
	}

	public Complexe addition(Complexe c){
		Complexe temp = new Complexe(this.getReelle()+c.getReelle(), this.getImag()+c.getImag()); 
		return temp;
	}

	public Complexe multiplication(Complexe c){
		double a1 = this.getReelle();
		double b1 = this.getImag();
		double a2 = c.getReelle();
		double b2 = c.getImag();
		Complexe temp = new Complexe(a1*a2-b1*b2, a1*b2+a2*b1);
		return temp;
	}
}
