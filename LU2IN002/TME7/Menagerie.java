public class Menagerie{
	private Animal[] tabA;
	private int nbAnimaux=0;

	public Menagerie(int n){
		tabA = new Animal[n];
	}
	
	public void ajouter(Animal a){
		tabA[nbAnimaux] = a;
		++nbAnimaux;
	}

	public String toString(){
		String s = "";
		for (int i=0; i<tabA.length; i++){
			s += tabA[i] + "\n";
		}
		return s;
	}

	public void midi(){
		for (int i=0; i<tabA.length; i++){
			tabA[i].crier();
		}
	}

	public void vieillirTous(){
		for (int i=0; i<tabA.length; i++){
			tabA[i].vieillir();
		}
	}

}
