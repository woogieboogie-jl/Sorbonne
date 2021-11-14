public class Instrument{
	private double poids;
	private double prix;

	public Instrument(double poids, double prix){
		this.poids = poids;
		this.prix = prix;
	}
	public String jouer() { return "L'insturemnt joue";}
	public String toString(){ return "Je suis un instrument"; }
}
