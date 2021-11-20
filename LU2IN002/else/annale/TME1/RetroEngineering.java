public class RetroEngineering{
	private int[] tab;
	public RetroEngineering(int n){
		if (n==1) {
			tab = new int[] {1};
		} else if (n==2) {
			tab = new int[] {1,2};
		} else {
			tab = new int[n];
			tab[0] = 1;
			tab[1] = 2;
			for (int i=2; i<tab.length; i++){
				tab[i] = tab[i-1] + tab[i-2];
			}
		}
	}

	public String toString(){
		String s = "";
		for (int i=0; i<tab.length; i++){
			s += String.format("%d", tab[i]) + " ";
		}
		return s;
	}

	public static void main(String args[]){
		RetroEngineering R1 = new RetroEngineering(4);
		System.out.println(R1.toString());
		RetroEngineering R2 = new RetroEngineering(123);
		System.out.println(R2.toString());
	}
}





