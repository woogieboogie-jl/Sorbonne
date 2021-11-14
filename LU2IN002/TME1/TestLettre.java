//Exercise 11

public class TestLettre{
	public static void main(String[] args){
		String s = "";
		char c;
		int counter = 0;

		for(c = 'a'; c<='z'; ++c){
			counter += 1;
			Lettre letter = new Lettre(c);
			s += letter.getCarac() + " ";
			if(counter%5==0){
				s += "\n";
			}
		}
		System.out.print(s);
	}
}
