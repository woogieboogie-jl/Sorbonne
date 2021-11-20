class Bouteille {
	private double volume;
	public Bouteille(double volume){
		this.volume = volume;
	}
	public Bouteille(){
		this(1.5);
	}
	public String toString(){
		return ("Voulume : " + volume);
	}
}

public class TestBouteille{
	public static void main(String args[]){
		Bouteille b1 = new Bouteille();
		System.out.println(b1.toString());
	}
}
