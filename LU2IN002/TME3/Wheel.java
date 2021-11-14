class Wheel{
	private int diameter;
	public Wheel(int diameter){
		this.diameter = diameter;
	}
	public Wheel(){
		this(60);
	}
	public int getDiameter(){
		return this.diameter;
	}
}
