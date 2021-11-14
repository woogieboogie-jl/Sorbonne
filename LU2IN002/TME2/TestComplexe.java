//Exercise 20

public class TestComplexe{
	public static void main(String[] args){
		
		Complexe c1 = new Complexe();
		Complexe c2 = new Complexe();
		Complexe c3 = new Complexe();
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());

		System.out.println(c1.toString() + " is real number?: " + c1.estReel());
		System.out.println(c2.toString() + " is real number?: " + c2.estReel());
		System.out.println(c3.toString() + " is real number?: " + c3.estReel());


		Complexe c4 = c1.addition(c2);
		Complexe c5 = c4.multiplication(c3);
		System.out.println(c1.toString() + " + " + c2.toString() + "  =  " + c4.toString());
		System.out.println(c4.toString() + " * " + c3.toString() + "  =  " + c5.toString());

	}
}
