import java.util.ArrayList;
import java.lang.Math.*;

public class Foret {
	private Object[][] terrain;


	public Foret(int n) {
		terrain = new Object[n][];
		for (int i=0; i<terrain.length; i++) {
			terrain[i] = new Object[n];
		}
	}

	public boolean placer(Object obj) {
		int x = (int)(Math.random()* this.terrain.length);
		int y = (int)(Math.random()* this.terrain.length);
		if (terrain[x][y] != null) {
			return false;
		} else {
			terrain[x][y] = obj;
			return true;
		}
	}


	public String toString() {
		String t = "";
		for (int i=0; i<terrain.length; i++) {
			String l = "";
			for (int j=0; j<terrain[i].length; j++) {
				if (terrain[i][j] != null) { 
					l += terrain[i][j].toString().charAt(0);
				} else {
					l += " ";
				}
				l += " ";
			}
			t += "| "+ l + "|" + "\n";	
		}
		return t;
	}

	public ArrayList<Champignon> ramasserChampignons() {
		ArrayList<Champignon> arr_c = new ArrayList<Champignon>();
		for (int i=0; i<terrain.length; i++) {
			for (int j=0; j<terrain[i].length; j++) {
				if ( terrain[i][j] !=null && terrain[i][j] instanceof Champignon ) {
					arr_c.add((Champignon)terrain[i][j]);
					terrain[i][j] = null;
				}
			}
		}
		return arr_c;
	}

	public ArrayList<Ramassable> ramasserTout() {
		ArrayList<Ramassable> arr_r = new ArrayList<Ramassable>();
		for (int i=0; i<terrain.length; i++) {
			for (int j=0; j<terrain[i].length; j++) {
				if ( terrain[i][j] != null && terrain[i][j] instanceof Ramassable ) {
					arr_r.add((Ramassable)terrain[i][j]);
					terrain[i][j] = null;
				}
			}
		}
		return arr_r;
	}
	
	public void ramasser(Panier p) {
		for (int i=0; i<terrain.length; i++) {
			for (int j=0; j<terrain[i].length; j++) {
				if ( terrain[i][j] != null && terrain[i][j] instanceof Ramassable ) {
					boolean r = p.add( (Ramassable) terrain[i][j] );
					if ( r == true ) {
						terrain[i][j] = null;
					}
				}
			}
		}
	}


}
