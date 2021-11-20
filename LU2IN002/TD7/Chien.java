class Mammifere{}
public class Chien extends Mammifere {
	public void aboyer() { System.out.println("Ouaff"); }
	public static void main(String[] args){
		Chien c1 = new Chien();
		
		Mammifere m1 = c1;
		// Ca marche
		
		Chien c2 = (Chien) m1;
		// Explicit cast works for classes on heritage

		Chien c3 = m1;
		// Ca ne marchera pas parce que m1 est un mammifere est un sous class d'un class Chien - mais ca marchera avec un cast explicit

		Mammifere m2 = new Mammifere();
		m1.aboyer();
		// ca ne compile pas parce que m1 est un mammiefaire

		// Il y aura une erreur dans le niveau de compilation parce que aboyer method n'existe pas
		((Chien)m1).aboyer();
	}
}
