class Planete{
	private String nom;
	private double rayon;


	public Planete(String n, double r){
		nom = n;
		rayon = r;
	}

	public Planete(String nom){
		this.nom = nom;
		this.rayon = 1000;
	}

	public String toString(){
		String s = "Planete " + nom;
		s += " de rayon "  + rayon;
		return s;
	}

}


public class TestPlanete{
	public static void main(String[] args){
		Planete p1 = new Planete("Mercurie", 2439.7);
		Planete p2 = new Planete("terre");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}
}
