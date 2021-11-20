public class TestPersonne {
	public static void main(String[] args){
	Personne p = new Personne("Albert");
	p.ajouterEnfant();

	Etudiant e = new Etudiant("Ahmed", null, "L2");
	e.ajouterEnfant();
	System.out.println(e.estEnL2());

	Salarie s3 = new Salarie("Yves", "0123401234", 2000);
	s3.ajouterEnfant();
	s3.ajouterEnfant();
	System.out.println(s3.getNbEnfants());
	System.out.println(s3.prime());
	}
}
