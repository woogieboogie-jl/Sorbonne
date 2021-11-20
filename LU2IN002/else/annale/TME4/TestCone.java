public class TestCone{
	public static void main(String args[]){
		Cone c1 = new Cone();
		Cone c2 = new Cone(1.231, 10.23);
		System.out.println(Cone.nbCones());

		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}
