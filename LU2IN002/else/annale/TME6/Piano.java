class Piano extends Instrument{

	public Piano(double poids, double prix){
		super(poids, prix);
	}
	public Piano(){
		super();
	}
	public void joue(){
		System.out.println("La Piano joue");
	}
	public String toString(){
		return "Piano " + super.toString();
	}
}
