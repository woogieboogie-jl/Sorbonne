import static java.lang.Math.*;

class Villageois {
	private String nom;
	private double poids;
	private boolean malade;

	public Villageois(String nomVillageois) {

		nom = nomVillageois;
		poids = (double)(Math.random()*100 + 50);
		double randommalade = (double)(Math.random());

		if (randommalade < 0.2) {
			malade = true;
		} else {
			malade = false;
		}

	}

	public String toString(){
		String ismalade;
		
		if (malade == true){
			ismalade = "oui";
		} else {
			ismalade = "non";
		}

		String s = "villageois : " + nom + ",  poids : " + String.format("%.2f",poids) + " kg , malade : " + ismalade + " , peut soulever " + this.poidsSouleve()  + " kg";
		System.out.println(s);
		return s;
	}

	public String getNom(){
		return nom;
	}
	
	public double getPoids(){
		return poids;
	}

	public boolean getMalade(){
		return malade;
	}

	public double poidsSouleve(){
		if (malade == true){
			return poids/3;
		} else {
			return poids/4;
		}
	}
}
