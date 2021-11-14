public class Classeur {
	private int nbPages;
	public Classeur(){ nbPages=0; }
	public void ajouterPages(Classeur c) {
		nbPages+=c.nbPages;
		c.nbPages=0;
	}
}
