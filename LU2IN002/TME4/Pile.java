import java.util.*;

public class Pile{
	private int numb_limit;
	private int numb_now;
	private Machin[] tab;

	public Pile(int n){
		this.numb_limit = n;
		this.numb_now = 0;
		this.tab = new Machin[n];
	}

	public boolean estVide(){
		return this.numb_now == 0;
	}

	public boolean estPleine(){
		return this.numb_now == this.numb_limit;
	}

	public void empile(Machin m){
		if (this.estPleine()) {
			System.out.println("La pile est pleine \n");	
		} else {
			this.tab[this.numb_now] = m;
			this.numb_now += 1;
		} 
	}
	
	public Machin depile(){
		if (this.estVide()) {
			System.out.println("La pile est vide \n");
			return null;
		} else {
			Machin m = this.tab[this.numb_now-1];
			this.tab[this.numb_now-1] = null;
			this.numb_now -= 1;
			return m;
		}
	}

	public String toString(){
		String s = "";
		if (this.numb_now == 0){
			s = "aucune element dans la pile \n";
		} else { 
			for (int i = this.numb_now-1; i >=0 ; i--){
				s += this.tab[i].getNom() + " : " + this.tab[i].getVal() + "\n";
			}
		}
		s += "\n";
		return s;
	}
}
