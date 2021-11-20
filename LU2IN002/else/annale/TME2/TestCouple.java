class Couple{
	private int x,y;
	public Couple(int x, int y){
		this.x=x; this.y=y;
	}
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	public Couple addition(Couple c){
		int newX = this.x + c.x;
		int newY = this.y + c.y;
		return new Couple(newX, newY);
	}
}

public class TestCouple{
	public static void main(String args[]){
		Couple cA = new Couple(1,5);
		System.out.println(cA.toString());
		Couple cB = new Couple(3,4);
		System.out.println(cB.toString());
	
		Couple cAPlusCB = cA.addition(cB);
		System.out.println(cAPlusCB.toString());
	}
}
