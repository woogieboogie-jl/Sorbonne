public class Point{
	private int x,y;
	public Point(int a, int b){ x=a; y=b; }
	public Point(Point p){ this.x=p.x; this.y=p.y; }
	public Point(){ x=0; y=0; }
	public boolean equals(Point p){
		if (this.x == p.x && this.y == p.y) { return true; } else { return false; }
	}

	public static void main(String[] args){
		Point p1 = new Point(5,2);
		Point p2 = new Point(5,2);
		Point p3 = p1;
		Point p4 = new Point(1,1);
		System.out.println("p1=p2 : "+p1.equals(p2));
		System.out.println("p1=p3 : "+p1.equals(p3));
		String s1 = new String("Bonjour");
		System.out.println("p1=s1 : "+p1.equals(s1));
	}
}
