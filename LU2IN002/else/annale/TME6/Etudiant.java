public class Etudiant extends Personne {
	private String cursus;
	public Etudiant(String n, String t, String c){
		super(n,t);
		this.cursus = c;
	}
	public boolean estEnL2() { return cursus.equals("L2"); }

	public void afficherInfo() {
		System.out.println("Nom : " +nom);
		System.out.println("NumTel : "+numTel);
		System.out.println("NbEnfants : "+nbEnfants);
		System.out.println("Cursus : "+cursus);
	}
	public void modifierInfo(String numTel, String cursus){
		this.numTel = numTel;
		this.cursus = cursus;
	}

}
