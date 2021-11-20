public class Personne {
	protected final String nom;
	protected String numTel;
	private int nbEnfants;
	public Personne(String nom, String numTel){
		this.nom = nom; this.numTel = numTel;
	}
	public Personne(String nom){
		this(nom,null);
	}
	public String getNom() { return nom; }
	public String getNumTel() { return numTel; }
	protected int getNbEnfants() { return nbEnfants; }
	public void ajouterEnfant() { nbEnfants++; }
}
