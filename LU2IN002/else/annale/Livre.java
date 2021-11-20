class Livre{
	private String titre;
	private int numero;
	private static int cnt=0;

	public Livre(String titre){
		this.titre=titre;
		this.cnt+=1;
		this.numero=this.cnt;
	}

	public String toString(){
		return "livre " + this.numero + " : " + this.titre;
	}

	public static void main(String args[]){
		Livre l1 = new Livre("Le Petit Prince");
		System.out.println(l1);
	}
}
