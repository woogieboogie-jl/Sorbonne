public class Vehicule{
	protected final int ID;
	protected static int cpt = 0;
	protected String marque;
	protected int distance = 0;

	public Vehicule(String marque){
		cpt += 1;
		this.ID = cpt;
		this.marque = marque;
	}

	public String toString(){
		return "Vehicule de marque : " + this.marque;
	}
}
