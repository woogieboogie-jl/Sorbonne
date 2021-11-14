import java.lang.Math.*;

public class Machin{
	private String nom;
	private int val;

	public Machin(String nom, int val){
		this.nom = nom;
		this.val = val;
	}
	
	public Machin(String nom){
		this(nom, (int)(Math.random() * 100));
	}
	
	public String getNom(){
		return this.nom;
	}

	public int getVal(){
		return this.val;
	}
}
