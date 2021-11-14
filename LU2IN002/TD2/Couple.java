public class Couple{
	private int x,y;
	public Couple(int x, int y){
		this.x = x; 
		this.y = y;
	}
	public String toString(){
		return "("+x+", "+y+")";
	}
	public Couple addition(Couple c){
		return new Couple(this.x + c.x , this.y + c.y);
	}
}



