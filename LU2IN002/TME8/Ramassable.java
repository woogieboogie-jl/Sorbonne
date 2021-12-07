import java.lang.Math.*;

public class Ramassable {
	protected double poids;
	protected String nom;

	public Ramassable(int n, String nom) {
		this.nom = nom;
		this.poids = (double) Math.random() * n;
	} 

	public double getPoids() { return poids; }
}
