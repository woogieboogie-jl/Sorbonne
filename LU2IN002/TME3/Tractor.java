class Tractor{
	private Cabin cabin;
	private Wheel w1;
	private Wheel w2;
	private Wheel w3;
	private Wheel w4;
	public Tractor(Cabin cabin, Wheel w1, Wheel w2, Wheel w3, Wheel w4){
		this.cabin = cabin;
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;
		this.w4 = w4;
	}
	public String toString(){
		return cabin.toString() + "  wheel: " + String.format("%d", w1.getDiameter()) + "/" + String.format("%d", w2.getDiameter()) + "/" + String.format("%d", w3.getDiameter())+ "/" +String.format("%d", w4.getDiameter());	
	}
	public void paint(String color){
		this.cabin.setColor(color);
	}
	public Tractor clone(){
		w1 = new Wheel(this.w1.getDiameter());
		w2 = new Wheel(this.w2.getDiameter());
		w3 = new Wheel(this.w3.getDiameter());
		w4 = new Wheel(this.w4.getDiameter());
		cabin = new Cabin(this.cabin.getVolume(), this.cabin.getColor());
		return new Tractor(cabin, w1, w2, w3, w4);
	}
}

