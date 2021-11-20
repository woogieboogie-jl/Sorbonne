

class TrianglePascal{
	private int[][] tab;
	public TrianglePascal(int n){
		this.tab = new int[n][];
	}

	public void remplirTriangle(){
		for (int i=0; i<tab.length; i++){
			tab[i] = new int[i+1];
			for (int j=0; j<tab[i].length; j++){
				if (j==0 || j==i){
					tab[i][j] = 1;
				} else {
					tab[i][j] = tab[i-1][j-1] + tab[i-1][j];
				}
			}
		}
	}

	public String toString(){
		String s = "";
		for (int i=0; i<tab.length; i++){
			String s_part = "";
			for (int j=0; j<tab[i].length; j++){
				s_part += String.format("%d", tab[i][j]) + " ";
			}
			s += s_part + "\n";
			
		}
		return s;
	}

	public boolean egal(int[][] tab){
		if (this.tab.length != tab.length){
			return false;
		} else {
			for (int i=0; i<this.tab.length; i++){
				if (this.tab[i].length != tab[i].length){
					return false;
				} else {
					for (int j=0; j<this.tab[i].length; j++){
						if (this.tab[i][j] != tab[i][j]){return false; }
					}
				}
			}
		}
		return true;
	}


}

public class TestTrianglePascal{
	public static void main(String args[]){
		TrianglePascal c = new TrianglePascal(22);
		c.remplirTriangle();
		System.out.println(c.toString());
		int[][] tab1 = new int[2][];
		tab1[0] = new int[] {1};
		tab1[1] = new int[] {1,1};

		int[][] tab2 = new int[3][];
		tab2[0] = new int[] {1};
		tab2[1] = new int[] {1,1};
		tab2[2] = new int[] {1,2,1};
		
		int[][] tab3 = new int[4][];
		int[][] tab4 = new int[5][];
		tab3[0] = new int[] {1};
		tab3[1] = new int[] {1,1};
		tab3[2] = new int[] {1,4,1,2};

		TrianglePascal c1 = new TrianglePascal(2);
		c1.remplirTriangle();

		System.out.println(c1.egal(tab1));

		TrianglePascal c2 = new TrianglePascal(3);
		c2.remplirTriangle();

		System.out.println(c2.egal(tab2));

		System.out.println(c2.egal(tab3));
		System.out.println(c2.egal(tab4));

	}
}
