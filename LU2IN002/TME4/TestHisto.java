import java.lang.Math.*;

class TestHisto{
	public static void main(String[] args){
		int[] tab = new int[150];
		for (int i=0; i < tab.length; i++){
			tab[i] = (int)(Math.random() * 20);
		}
		Histo hist = new Histo(tab);
		System.out.println(hist.afficheHistogrammeTableau());
		System.out.println(hist.afficheHistogramme());
		hist.ajouteNote(0);
		System.out.println(hist.afficheHistogrammeTableau());
		System.out.println(hist.afficheHistogramme());
	}
}
