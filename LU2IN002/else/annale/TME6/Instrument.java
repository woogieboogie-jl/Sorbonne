import static java.lang.Math.*;

class Instrument{
	private double poids;
	private double prix;

	public Instrument(double poids, double prix){
		this.poids = poids;
		this.prix = prix;
	}

	public Instrument(){
		this.poids = (double)(Math.random()*10 + 5);
		this.prix = (double)(Math.random()*20000 + 200);
	}

	public String toString(){
		return "Instrument, Poids: " + String.format("%.2f", poids) + " Prix: " + String.format("%.2f", prix);
	}

	public void jouer(){
		System.out.println("Un Instrument joue");
	}
}
