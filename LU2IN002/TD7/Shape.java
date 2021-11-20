public abstract class Shape {
	protected double x,y;
	public Shape() { x = 0; y = 0; }
	public Shape(double x, double y) { this.x = x; this.y = y; }
	public String toString() { return "Position : (" + x + "," + y + ")";}
	public abstract double surface();
}

public class Circle extends Shape {
	private double radius;
	public Circle() {
		super();
		radius = 1;
	}
	public Circle(double x, double y, double r){
		super(x,y);
		radius = r;
	}
	public double surface() { return Math.PI*radius*radius; }
	public String toString() {
		return super.toString() + " Rayon : " + radius;
	}
}

public class Rectangle extends Shape{
	private double height,length;

	public Rectangle() {
		super();
		length = Math.Random()*10;
		height = Maht.Random()*10;
	}

	public Rectangle(double x, double y, double length, double height){
		super(x,y);
		this.length = length;
		this.height = height;
	}

	public double surface() { return length*height; }

	public String toString() { return super.toString() + " length : " + length + " height : " + height; }
}


Shape[] formes = new Shape[3];
formes[0] = new Circle();
formes[1] = new Rectangle();
formes[2] = new Rectangle(1,2,3,4);

double total = 0;
for (Shape s; formes){
	total += s.surface();
}

//50.1 - toutes les membres

//50.2 - parce que surface(), la method abstract n'est pas redefinie dans le class Circle. un method abstract, ca doit etre definie. + class circle n'est pas un class abstraite.

//50.3 - tous les form a un different method pour calculer la surface
//50.4 - code added.
//50.5 - code added.



public class Z {
	public abstract void f();
	public abstract void g() {};
	public void h();
}
// erreur parce class Z n'est pas un class abstract quand il y a des method abstractes dedans


public abstract class A{
	public abstract void f()'
}
public class B extends A {}

// class B doit redefinir la method f ou bien effacer le symbol d'abstract de la method f. ou bien class B doit etre abstract aussi
