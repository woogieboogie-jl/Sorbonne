public class Salarie extends Personne{
	private double salarie;

	public Salarie(String n, String t, double s){
		super(n,t);
		this.salarie = s;
	}

	public Salarie(String n, double s){
		super(n,null);
		this.salarie = s;
	}

	public double prime(){
		return (this.getNbEnfants() * 0.05 * this.salarie);
	}

	public double getSalarie() { return salarie; }
}

