//Exercise 9

class Segment{
	private int x;
	private int y;

	public Segment(int extX, int extY){
		x = extX;
		y = extY;
	}

	public int longeur(){
		if (x>y) {
			return x-y;
		} else {
			return y-x;
		}
	}

	public String toString() {
		String s = "Segment [" + x + "," + y + "]";
		return s;
	}
}


public class TestSegment{
	public static void main(String[] args){

		Segment seg1 = new Segment(6,8);
		Segment seg2 = new Segment(12,5);

		if (seg1.longeur() > seg2.longeur()) {
			System.out.println(seg1.toString() + " is longer");
		} else if (seg1.longeur() < seg2.longeur()) {
			System.out.println(seg2.toString() + " is longer");
		} else {
			System.out.println(seg1.toString() + " and" + seg2.toString() + " are in same length");
		}
	}
}
