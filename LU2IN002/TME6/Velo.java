public class Velo extends SansMoteur{
	private int vitesses;

	public Velo(String marque, int vitesses){
		super(marque);
		this.vitesses = vitesses;
	}

	public String toString(){
		return "Velo " + String.format("%d",super.id) + " de marque " + super.marque + " de vitesses " + String.format("%d",this.vitesses);   
	}

	public void transproter(String depart, String arrivee){
		System.out.println("Le velo " + String.format("%d", super.id) +
	" se deplace de " + depart + " a " + arrivee); 
	}

	public void rouler(double distance){
		super.rouler(distance);
		System.out.println(this.toString() + " a roule " + String.format("%.2f", super.distance) + " km" );
	}
}
