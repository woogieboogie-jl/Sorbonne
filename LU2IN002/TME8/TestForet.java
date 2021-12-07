import java.util.ArrayList;
import java.lang.Math.*;

public class TestForet {
	public static void main(String[] args) {
		Foret f = new Foret(5);
		for (int i=0; i<20; i++) {
			double r = (double)(Math.random()*10);
			if (r<2) {
				f.placer(new Arbre("Pine"));
			} else if (r<7) {
				f.placer(new Champignon("Cepe"));
			} else {
				f.placer(new ChampignonToxique("Toxique"));
			}
		}
		System.out.println(f.toString());
		
		Panier p = new Panier(8);
		f.ramasser(p);
		System.out.println(p.toString());
		System.out.println(f.toString());
	}
}
