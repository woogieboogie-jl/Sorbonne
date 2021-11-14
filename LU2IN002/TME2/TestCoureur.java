//Exercise 19

public class TestCoureur{
	public static void main(String[] args){
		Coureur c1 = new Coureur(12);
		Coureur c2 = new Coureur();
		Coureur c3 = new Coureur(54);
		Coureur c4 = new Coureur();
		double temps = 0;
		c1.premierTemoin();

		c1.courir();
		c1.passeTemoin(c2);
		temps += c1.getTempsAu100();
		c2.courir();
		c2.passeTemoin(c3);
		temps += c2.getTempsAu100();
		c3.courir();
		c3.passeTemoin(c4);
		temps += c3.getTempsAu100();
		c4.courir();
		temps += c4.getTempsAu100();

		System.out.println("it takes:" +String.format("%.1f",temps)+"s to finish 400m lap.");

		

	}
}
