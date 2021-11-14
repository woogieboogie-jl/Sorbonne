public class Vehicule{
	static int compt;
	protected int id;
	protected String marque;
	protected double distance=0;

	public Vehicule(String marque){
		this.marque = marque;
		compt ++;
		this.id = compt;
	}

	public String toString(){
		return "Vehicule " + String.format("%d", this.id) + " de marque " + this.marque;
	}

	public void rouler(double distance){
		this.distance += distance; 
	}

	public double getDistance(){
		return this.distance;
	}
}
