import java.lang.Math.*;

class Pion{
	private String nom;
	private double posx;
	
	public Pion(String nom, double posx){
		this.nom = nom;
		this.posx = posx;
	}
	
	public Pion(String nom){
		this(nom, Math.random());
	}


	public Pion clone(){
		return new Pion(this.nom, this.posx);
	}
	
	public void setNom(String nom){ this.nom = nom; }
	public String getNom() { return this.nom; }
}


public class TestPion {
	public static void main(String[] args){
		Pion unPion = new Pion("Hello");

		Pion autrePion = unPion.clone();
		autrePion.setNom("Dormeur");
		System.out.println(unPion.getNom());
		System.out.println(autrePion.getNom());
	}	
}
