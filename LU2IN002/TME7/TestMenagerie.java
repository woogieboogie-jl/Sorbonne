public class TestMenagerie{
	public static void main(String args[]){
		Animal a1 = new AnimalPattes("Renard", 4,4);
		AnimalSansPattes a2 = new AnimalSansPattes("Serpent",12);
		AnimalPattes a3 = new AnimalPattes("Millepattes",1, 750);
		
		Menagerie M1 = new Menagerie(3);
		M1.ajouter(a1);
		M1.ajouter(a2);
		M1.ajouter(a3);

		M1.midi();
		M1.vieillirTous();
		M1.midi();
	}
}
