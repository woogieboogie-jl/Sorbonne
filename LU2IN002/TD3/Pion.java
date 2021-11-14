import static java.lang.Math.*;

public class Pion {
	private String nom;
	private Point pos;

	public Pion(String nom){
		this.nom = nom;
		this.pos = new Point();
	}
	public Pion clone(){
		return new Pion(this.nom);
	}
	public void setNom(String nom) { this.nom = nom; }
	public String getNom() {return this.nom;}
	public Point getPoint() {return this.pos;}
	public void seDeplacer(){
		this.pos.bouger();
	}
}
