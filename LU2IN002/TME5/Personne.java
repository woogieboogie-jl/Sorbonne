public class Personne{
	private String nom;
	private static int nbPersonnes;
	
	public Personne(){
		this.nom = "Individu" + (char)(nbPersonnes+65);
		nbPersonnes += 1;
	}

	public String toString(){
		return this.nom;
	}
	
	public static int getNbPersonnes(){
		return nbPersonnes;
	}



}
