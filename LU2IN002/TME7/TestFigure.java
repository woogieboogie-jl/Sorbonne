public class TestFigure{
	public static void main(String args[]){
		Figure[] tabF = new Figure[4];
		tabF[0] = new Rectangle();
		tabF[1] = new Carre();
		tabF[2] = new Ellipse();
		tabF[3] = new Cercle();

		for (int i=0; i<tabF.length; i++){
			System.out.println( tabF[i].toString() + " perimetre: " + tabF[i].perimetre() + " surface: " + tabF[i].surface());
		}
	}
}
