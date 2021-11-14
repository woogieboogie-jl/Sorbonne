public class Projet{
	private String nom; 
	private Trio trio;
	private static int nbProjet;

	public Projet(String nom){
		this.nom = nom;
		this.trio = new Trio();
		nbProjet += 1;
	}

	public String toString(){
		return "Projet " + this.nom + " " + this.trio.toString(); 
	}

	public static int getNbProjets(){
		return nbProjet;
	}
}
