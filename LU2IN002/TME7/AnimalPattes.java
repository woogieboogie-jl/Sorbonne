public class AnimalPattes extends Animal{
	private int nbPattes;
	public AnimalPattes(String nom, int age, int nbPattes){
		super(nom, age);
		this.nbPattes = nbPattes;
	}
	public void crier(){
		System.out.println(super.toString() + " avec " + nbPattes + " pattes" + " crie!");
	}
}
