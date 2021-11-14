public class TestCone{
	public static void main(String[] args){
		System.out.println(Cone.getnbCones());
		Cone c1 = new Cone(10,20);
		Cone c2 = new Cone();
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(Cone.getnbCones());
	}
}
