import java.lang.Math.*;
public class Tableaux{
	public static void main(String args[]){
		int[][] tab = new int[3][];
		for (int i=0; i<tab.length; i++){
			tab[i] = new int[i+1];
			for (int j=0; j<tab[i].length; j++){
				tab[i][j] = i+1;
			}
		}
		for (int i=0; i<tab.length; i++){
			String s = "";
			for (int j=0; j<tab[i].length; j++){
				s += String.format("%d", tab[i][j]) + " ";
			}
			System.out.println(s);
		}
	}
}
