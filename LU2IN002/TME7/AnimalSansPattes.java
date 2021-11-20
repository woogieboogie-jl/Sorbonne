public class AnimalSansPattes extends Animal{
	private int nbPattes = 0;
	public AnimalSansPattes(String nom, int age){
		super(nom, age);
	}
	public void crier(){
		System.out.println(super.toString() + " sans pattes" + " crie!" );
	}
}
