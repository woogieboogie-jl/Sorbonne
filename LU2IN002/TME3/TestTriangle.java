// Exercise 26

public class TestTriangle{
	public static void main(String[] args){
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point();
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		Triangle t1 = new Triangle(p1,p2,p3);
		Triangle t2 = new Triangle(p1,p2,p3);
		Triangle t3 = new Triangle();
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(t3.toString());
		System.out.println(t1.equalStructure(t2));
		System.out.println(t2.equalStructure(t3));
		System.out.println(t3.equalStructure(t1));
		
	}
}
