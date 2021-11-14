public class Bouteille{
	private double volume;

	public Bouteille(double volume){
		this.volume = volume;
	}

	public Bouteille(){
		this(1.5);
	}

	public void remplir (Bouteille b){
		volume += b.volume;
		b.volume = 0;
		/* this usually doesn't work becuase it violates encapsulation rules of OOP, however in Java, this is possible only we are handling operations with within same class types. but its is better to use get methods and set methods even in these cases */
	}

	public double getVolume(){
		return this.volume;
	}

	public String toString(){
		return ("volume du liquide dans la bouteille =" + volume);
	}
}
