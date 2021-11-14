public class Trio{
	private Personne[] tab;
	private static int nbTrio;
	
	public Trio(){
		this.tab = new Personne[] {new Personne(), new Personne(), new Personne()};
		nbTrio += 1;
	}

	public String toString(){
		return "Trio " + String.format("%d", nbTrio) + " : " + this.tab[0].toString() + " " + this.tab[1].toString() + " " + this.tab[2].toString();

	}

	public static int getNbTrios(){
		return nbTrio;
	}

}
