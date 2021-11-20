public abstract class Animal{
	protected String nom;
	protected int age;
	public Animal(String nom, int age){
		this.nom = nom;
		this.age = age;
	}
	public Animal(String nom){
		this.nom = nom;
		this.age = 1;
	}
	public String toString(){ return nom + " age : " + age; }
	public void vieillir(){ ++age; }
	public abstract void crier();
}
