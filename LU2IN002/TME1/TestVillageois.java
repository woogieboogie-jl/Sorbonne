//Exercise 10

import static java.lang.Math.*;

public class TestVillageois{
	public static void main(String[] args){
		Villageois v1 = new Villageois("James");
		Villageois v2 = new Villageois("Marry");
		Villageois v3 = new Villageois("Nancy");
		Villageois v4 = new Villageois("Alex");

		double rocher = (double)(Math.random() * 150) + 40;
		double souleve = v1.poidsSouleve() + v2.poidsSouleve() + v3.poidsSouleve() + v4.poidsSouleve();
		if (rocher <= souleve){
			System.out.println("Les villageois peuvent soulever: " + String.format("%2f",souleve) + " kg" + "  >=   Le rocher: " + String.format("%2f",rocher) + " kg,  OUI");
		} else {
			System.out.println("Les villageois peuvent soulever: " + String.format("%2f",souleve) + " kg" + "  <<   Le rocher: " + String.format("%2f",rocher) + " kg,  NON");
		}
	}
}



/*
10.3
The name of the file containing the class "TestVillageois" is "TestVillageois.java"

*/
