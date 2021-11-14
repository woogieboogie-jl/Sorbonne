public class Trompette extends Instrument{
	public Trompette(double poids, double prix){
		super(poids, prix);
	}
	public String toString() { return "Je suis un trompette"; }
	public String jouer() { return "la trompette joue"; }
}
