public class Voiture extends AMoteur{
	private int place;
	
	public Voiture(String marque, double capacite, double essence, int place){
		super(marque,capacite,essence);
		this.place = place;
	}
	
	public String toString(){
		return "La voiture " + String.format("%d", super.id);
	}

	public void rouler(double distance){
		super.rouler(distance);
		System.out.println(this.toString() + " a roule " +  String.format("%.2f", distance) + " km");
	}

	public void transporter(int nbPers, int km){
		if (super.enPanne()){
			System.out.println(this.toString() +  " n'a plus d'essence !");
		} else {
			super.rouler(km);
			System.out.println(this.toString() + " transporte " + String.format("%d", nbPers) + " sur " + String.format("%d", km) + " km");
		}
	}
}
