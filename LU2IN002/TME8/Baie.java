public class Baie extends Ramassable {

	String nom;
	double poids;

	public Baie(String nom) {
		this.nom = nom;
		this.poids = (double)(Math.random() * 1);
	}

	public String toString() {
		return nom + " " + String.format("%.2f", poids);
	}
}
