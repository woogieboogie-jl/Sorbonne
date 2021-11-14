// Exercise 25

class TestTractor{
	public static void main(String[] args){
		Wheel w1 = new Wheel(120);
		Wheel w2 = new Wheel(120);
		Wheel w3 = new Wheel();
		Wheel w4 = new Wheel();
		Cabin cabin = new Cabin(12, "blue");
		Tractor t1 = new Tractor(cabin,w1,w2,w3,w4); 
		System.out.println(t1.toString());
		Tractor t2 = t1.clone();
		t2.paint("yellow");
		System.out.println(t2.toString());
	}
}
