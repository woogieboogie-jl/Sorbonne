public class TestProjet{
	public static void main(String[] args){
		System.out.println(Personne.getNbPersonnes());
		Personne p1 = new Personne();
		Personne p2 = new Personne();
		System.out.println(p1.toString());
		System.out.println(Personne.getNbPersonnes());
		Trio t1 = new Trio();
		System.out.println(t1.toString());
		Projet pro1 = new Projet("P3X-774");
		Projet pro2 = new Projet("P3R-233");
		System.out.println(pro1.toString());
		System.out.println(pro2.toString());

		System.out.println("Personnes crees :" + String.format("%d", Personne.getNbPersonnes()));
		System.out.println("Trios crees :" + String.format("%d", Trio.getNbTrios()));
		System.out.println("Projets crees :" + String.format("%d", Projet.getNbProjets()));
	}
}
