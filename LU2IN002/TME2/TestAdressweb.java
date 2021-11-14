//Exercise 18

public class TestAdressWeb{
	public static void main(String[] args){
		AdressWeb adr1 = new AdressWeb("ftp", "supersite.fr", "/rep1/rep2/rep3/rep4/index.html");
		AdressWeb adr2 = new AdressWeb("supersite2.fr", "/rep1/rep2/rep3/rep4/index.html");
		AdressWeb adr3 = new AdressWeb("supersite3.fr");
		System.out.println(adr1.toString());
		System.out.println(adr2.toString());
		System.out.println(adr3.toString());
	}
}
