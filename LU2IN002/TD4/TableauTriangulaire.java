public class TableauTriangulaire{
	public static void main(String[] args){
		int[][] tab = new int[3][];
		for (int i=0; i<tab.length; i++){
			tab[i] = new int[i+1];
			for (int j=0; j<tab[i].length; j++){
				tab[i][j] = i+1;
			}
		}
		int[][] tab1 = {{1}, {2,2}, {3,3,3}};
	}
}
