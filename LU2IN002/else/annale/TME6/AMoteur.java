public class AMoteur extends Vehicule{
	protected int cap;
	protected int niveau = 0;
	
	public AMoteur(String marque, int cap){
		super(marque);
		this.cap = cap;
	}

	public String toString(){
		return super.toString() + " roule avec moteur de cap: " + this.cap;
	}

}
