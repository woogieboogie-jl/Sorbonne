import java.util.ArrayList;

public class Panier extends ArrayList<Ramassable> {
	private double poidsMax;
	private double poids = 0;

	public Panier(double d) {
		this.poidsMax = d;
	}

	public double getPoids() {
		return poids; 
	}
	
	@Override
	public boolean add(Ramassable ram) {
		if (poids + ram.getPoids() > poidsMax) {
			System.out.println("ram.toString() + n'est pas ajouté au panier");
			return false;
		} else {
			super.add(ram);
			System.out.println(ram.toString() + " est ajouté au panier");
			poids += ram.getPoids();
			return true;
		}
	}

	public int compterToxiques() {
		int cnt = 0;
		for (int i=0; i<super.size(); i++) {
			if ( this.get(i) instanceof Toxique ) {
				cnt += 1;
			}
		}
		return cnt;
	}

	public String toString() {
		String s = "Panier contenant " + super.size() + " choses, dont " + this.compterToxiques() + " toxiques  ( " + String.format("%.1f",this.getPoids()) + "kg sur " + this.poidsMax + "kg )";
		return s;
	}

}
