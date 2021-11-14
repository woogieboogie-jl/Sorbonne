import static java.lang.Math.*;

public class Coureur{
	private int numDossard;
	private double tempsAu100;
	private boolean possedeTemoin;

	public Coureur(int numDossard){
		this.numDossard = numDossard;
		this.tempsAu100 = (double)(Math.random()*4 ) + 12;
		this.possedeTemoin = false;
	}
	public Coureur(){
		this.numDossard = (int)(Math.random()*1000);
		this.tempsAu100 = (double)(Math.random()*4 ) + 12;
		this.possedeTemoin = false;
	}
	public String getNumDossard(){
		return String.format("%d",this.numDossard);
	}
	public double getTempsAu100(){
		return this.tempsAu100;
	}
	public String getPossedeTemoin(){
		if (this.possedeTemoin == true){
			return "oui";
		} else {
			return "non";
		}
	}
	public String toString(){
		return "Coureur: " + this.getNumDossard() + " / tempsAu100: " + this.getTempsAu100() +"s" +  " / possedeTemoin: " + this.getPossedeTemoin(); 
	}
	public void premierTemoin(){
		this.possedeTemoin = true;
	}
	public void passeTemoin(Coureur c){
		this.possedeTemoin = false;
		c.possedeTemoin = true;
		String s = "moi, coureur " + this.getNumDossard() + ", je passe le temoin au coureur " + c.getNumDossard();
		System.out.println(s);
	}
	public void courir(){
		String s = "je suis la coureur " + this.getNumDossard() + " et je cours";
		System.out.println(s);
	}
}
