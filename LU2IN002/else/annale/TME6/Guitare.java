class Guitare extends Instrument{
	public Guitare(){
		super();
	}

	public Guitare(double poids,double prix){
		super(poids, prix);
	}

	public void joue(){
		System.out.println("La Guitare joue");
	}
	
	public String toString(){
		return "Guitare " + super.toString();
	}
}
