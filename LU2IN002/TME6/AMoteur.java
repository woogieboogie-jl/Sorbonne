public class AMoteur extends Vehicule{
	protected double capacite;
	protected double essence=0;
	public AMoteur(String marque, double capacite, double essence){
		super(marque);
		this.capacite = capacite;
		this.essence = essence;
	}
	
	public String toString(){
		return "Je suis AMoteur";
	}

	public void approvisionner(double nbLitres){
		this.essence += nbLitres;
		if (this.essence > this.capacite) {
			this.essence = this.capacite;
		}
	}

	public boolean enPanne(){
		if (this.essence == 0){
			return true;
		}
		return false;
	}

	public void rouler(double distance){
		if (this.enPanne()){
			;
		} else {
			super.rouler(distance);
		}
	}

}
