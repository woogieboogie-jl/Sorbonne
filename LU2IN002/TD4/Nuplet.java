public class Nuplet{
	private int[] tab;
	public Nuplet(int n){
		tab = new int[n];
	}
	public Nuplet(int n, int x){
		this(n);
		for (int i=0; i<tab.length; i++){
			tab[i] = x;
		}
	}
	public Nuplet(int a, int b, int c){
		this(3);
		tab[0] = a;
		tab[1] = b;
		tab[2] = c;
	}
	public Nuplet(int [] tab){
		this(tab.length);
		for(int i=0; i<tab.length; i++){
			this.tab[i] = tab[i];
		}
	}
	public String toString(){
		if (tab.length == 0) { return "()"; };
		String s = "(";
		for (int i=0; i<(tab.length-1); i++) {
			s = s+ tab[i] + ",";
		}
		s = s + tab[tab.length - 1];
		return s + ")";
	}

	public static void main(String[] args) {
	Nuplet nuplet1 = new Nuplet(5,3);
	Nuplet nuplet2 = new Nuplet(7,6,8);
	System.out.println(nuplet1.toString());
	}
	int[] t123 = {1,2,3}; 
	Nuplet nuplet3 = new Nuplet({1,2,3});
	System.out.println(t123 == nuplet3);
}
