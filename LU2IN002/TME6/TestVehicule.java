public class TestVehicule{
	public static void main(String[] args){
		Velo v1 = new Velo("MyVTT", 17);
		v1.rouler(10.0);
		Voiture vo1 = new Voiture("MyVTT", 14, 12, 5);
		vo1.transporter(4, 120);
		Camion ca1 = new Camion("MyVTT", 20, 12, 212);
		ca1.transporter("tuiles", 500);

		Vehicule[] tab = new Vehicule[] {v1, vo1, ca1};

		for (int i=0; i<tab.length; i++){
			tab[i].rouler(10);
		}
	}
}
