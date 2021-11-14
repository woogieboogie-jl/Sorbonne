public class TestCouple{
	public static void main(String[] args){
		Couple cA = new Couple(1,5);
		Couple cB = new Couple(3,7);

		Couple cAPluscB = cA.addition(cB);
		System.out.println(cAPluscB);
	}
}
