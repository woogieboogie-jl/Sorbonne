public class TestOrchestre{
	public static void main(String[] args){
		Orchestre o = new Orchestre(3);
		o.ajouterInstrument(new Guitare(1.23, 132.92));
		o.ajouterInstrument(new Piano(12.32, 756.23));
		o.ajouterInstrument(new Trompette(1.82, 456.23));
		System.out.println(o.jouer());
	}
}
