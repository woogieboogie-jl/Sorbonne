public class Camion extends AMoteur{
	private double volume;
	
	public Camion(String marque, double capacite, double essence, double volume){
		super(marque,capacite,essence);
		this.volume = volume;
	}

	public String toString(){
		return "Le camion " + String.format("%d", super.id);
	}

	public void rouler(double distance){
		if (super.enPanne()) {
			System.out.println(this.toString() + " n'a plus d'essence!");
		} else {
			super.rouler(distance);
			System.out.println(this.toString() + " a roule " + String.format("%.2f", distance) + " km");
		}

	}

	public void transporter(String materiau, int km){
		if (super.enPanne()) {
			System.out.println(this.toString() + " n'a plus d'essence!");
		} else {
			super.rouler(km);
			System.out.println(this.toString() + " a transporte des " + materiau + " sur " + String.format("%d", km) + " km");
		}
	}

}
