import java.lang.Math.*;

public class Tableaux{
	public static void main(String[] args){
		double[] tabD = new double[10];
		
		for (int i=0; i<tabD.length; i++){
			tabD[i] = Math.random();
		}

		for (int i=0; i<tabD.length; i++){
			System.out.println(tabD[i]);
		}

	}
}
