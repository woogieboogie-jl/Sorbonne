class Test{
	public static void main(String args[]){
		AspirateurAvecSac avecSac=new AspirateurAvecSac();
		AspirateurSansSac sansSac=new AspirateurSansSac();
		Aspirateur aspiAvecSac=new AspirateurAvecSac();
		Aspirateur aspiSansSac=new AspirateurSansSac();
		Appareil appAvecSac=new AspirateurAvecSac();
		avecSac.aspirer();
		sansSac.aspirer();
		aspiAvecSac.aspirer();
		aspiSansSac.aspirer();
	}
}
