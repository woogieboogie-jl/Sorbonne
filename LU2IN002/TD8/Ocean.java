import java.util.ArrayList;

public class Ocean {
	private ArrayList<Submarine> sea = new ArrayList<Submarine>();
	public void ajouter(Submarine s) {
		this.sea.add(s);
		System.out.println(s.toString());
	}

	public void listToString(){
		for (int i=0; i<sea.size(); i++) {
			System.out.println(sea.get(i).toString());
		}
	}
}
