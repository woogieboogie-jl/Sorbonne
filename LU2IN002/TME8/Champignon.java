import java.lang.Math.*;

public class Champignon extends Ramassable{
	
	public Champignon(String nom) {
		super(3, nom);
	}

	public String toString() {
		return nom + " " + String.format("%.2f", super.getPoids());
	}

}
