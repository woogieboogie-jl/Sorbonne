public class Alphabet{
	public static void main(String args[]){
	int i =0;
	while (i<10){
		String s = "";
		s += String.format("%d", i) + " and its ascii code: " + String.format("%d",(int)(String.format("%d",i).charAt(0)));
		System.out.println(s);
		i++;
	}
	char test = '1';
	String testInt = Character.toString(test);
	System.out.println(testInt);
	}
}
