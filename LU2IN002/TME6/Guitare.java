public class Guitare extends Instrument{
	public Guitare(double poids, double prix){
		super(poids,prix);
	}
	public String toString(){ return "Je suis un Guitare"; }
	public String jouer() { return "La guitare joue"; }
}

