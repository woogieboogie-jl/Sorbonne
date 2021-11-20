public class Segment{
	private int x;
	private int y;

	public Segment(int extX, int extY){
		this.x = extX;
		this.y = extY;
	}  

	public int longeur(){
		if (y>x){
			return y-x;
		} else {
			return x-y;
		}
	}

	public String toString(){
		return "Segment " + "[ " + String.format("%d",x) + " , " + String.format("%d",y) + " ]";
	}
}
