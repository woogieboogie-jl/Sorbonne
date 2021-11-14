import java.util.*;

public class Triangle{
	private Point p1;
	private Point p2;
	private Point p3;
	public Triangle(Point p1, Point p2, Point p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	public Triangle(){
		this.p1 = new Point();
		this.p2 = new Point();
		this.p3 = new Point();
	}
	public double getPerimeter(){
		double p = this.p1.distance(p2) + this.p2.distance(p3) + this.p3.distance(p1);
		return p;
	}
	public String toString(){
		return this.p1.toString() + this.p2.toString() + this.p3.toString();
	}
	public boolean equalStructure(Triangle t2){
		if (this.getPerimeter() != t2.getPerimeter()){
			return false;
		}
		Set<Double> struct_origin = new HashSet<Double>(3);
		struct_origin.add(this.p1.distance(this.p2));
		struct_origin.add(this.p2.distance(this.p3));
		struct_origin.add(this.p3.distance(this.p1));

		Set<Double> struct_compare = new HashSet<Double>(3);
		struct_compare.add(p1.distance(p2));
		struct_compare.add(p2.distance(p3));
		struct_compare.add(p3.distance(p1));

		if (struct_origin.size() != struct_compare.size()){
			return false;
		}
		if (struct_origin.containsAll(struct_compare)){
			return true;
		}
		else {
			return false;
		}
	}
}
