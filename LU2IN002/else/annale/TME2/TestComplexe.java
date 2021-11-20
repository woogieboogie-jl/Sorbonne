public class TestComplexe{
	public static void main(String args[]){
		Complexe c1 = new Complexe(0,1);
		System.out.println(c1.multiplication(c1));

		Complexe c2 = new Complexe(1,1);
		Complexe c3 = new Complexe(2,2);
		System.out.println(c2.multiplication(c3));
	}
}
