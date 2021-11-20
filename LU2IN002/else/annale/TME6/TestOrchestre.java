class TestOrchestre{
	public static void main(String args[]){
		Orchestre orc1 = new Orchestre(10);
		Guitare g1 = new Guitare();
		Trompette t1 = new Trompette();
		Piano p1 = new Piano();
		orc1.ajouterInstrument(g1);
		orc1.ajouterInstrument(p1);
		orc1.ajouterInstrument(t1);
		orc1.jouer();
	}
}
