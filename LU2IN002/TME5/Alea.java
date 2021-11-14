import java.lang.Math.*;

public class Alea{

	public static char lettre(){
		return (char)(Math.random() * 26 + 65);		
	}

	public static String chaine(){
		String s = "";
		for (int i=0; i<10; i++){
		s += Alea.lettre();
		}
		return s;
	}

	public static void main(String[] args){
		System.out.println(Alea.chaine());
	}


}
