public class TestPile{
	public static void main(String[] args){
		Pile p = new Pile(5);
		Machin m1 = new Machin("m1");
		Machin m2 = new Machin("m2");
		Machin m3 = new Machin("m3");
		System.out.print(p.toString());
		
		p.empile(m1);
		System.out.print(p.toString());
		p.empile(m2);
		System.out.print(p.toString());
		p.empile(m3);
		System.out.print(p.toString());

		Machin mout1 = p.depile();
		System.out.println("[element depile] "  +  mout1.getNom() + ":" + String.format("%d", mout1.getVal()) + "\n" );
		System.out.print(p.toString());
		
		Machin m4 = new Machin("m4");
		Machin m5 = new Machin("m5");
		p.empile(m4);
		p.empile(m5);
		System.out.print(p.toString());
		

		Machin mout2 = p.depile();
		Machin mout3 = p.depile();
		Machin mout4 = p.depile();
		Machin mout5 = p.depile();
		System.out.print(p.toString());
	}
}
