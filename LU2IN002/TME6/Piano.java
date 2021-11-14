public class Piano extends Instrument{
	public Piano(double poids, double prix){
		super(poids,prix);
	}
	public String toString(){ return "Je suis un Piano"; }
	public String jouer(){ return "Le piano joue"; }
}
