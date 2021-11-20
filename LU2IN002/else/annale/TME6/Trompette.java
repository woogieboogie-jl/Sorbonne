class Trompette extends Instrument{
	public Trompette(){
		super();
	}

	public Trompette(double poids, double prix){
		super(poids, prix);
	}

	public void jouer(){
		System.out.println("La Trompette joue");
	}
	
	public String toString(){
		return "Trompette " + super.toString();
	}
}
