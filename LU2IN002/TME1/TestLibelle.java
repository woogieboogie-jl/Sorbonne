//Exercise 13
import java.util.*;


class Numdict{
	private HashMap<Integer, String> Numdict;
	public Numdict(){
		Numdict.put(1,"un");
		Numdict.put(2,"deux");
		Numdict.put(3,"trois");
		Numdict.put(4,"quatre");
		Numdict.put(5,"cinq");
		Numdict.put(6,"six");
		Numdict.put(7,"sept");
		Numdict.put(8,"huit");
		Numdict.put(9,"neuf");
		Numdict.put(10,"dix");
		Numdict.put(11,"onze");
		Numdict.put(12,"dooze");
		Numdict.put(13,"treize");
		Numdict.put(14,"quatorze");
		Numdict.put(15,"quinze");
		Numdict.put(16,"seize");
		Numdict.put(17,"dix-sept");
		Numdict.put(18,"dix-huit");
		Numdict.put(19,"dix-neuf");
		Numdict.put(20,"vingt");
	}

	public String getText(int n){
		return Numdict.get(n);
	}
}





public class Libelle{
	public static void main(String[] args){
		Numdict dict = new Numdict();
		int n = Integer.parseInt(args[0]);
		System.out.println(dict.getText(n));
	}
}
