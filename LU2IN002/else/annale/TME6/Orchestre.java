class Orchestre{
	private Instrument[] tableau; 
	private int cpt = 0;
	private int maxTaille;

	public Orchestre(int n){
		this.tableau = new Instrument[n];
		this.maxTaille = n;
	}

	public void ajouterInstrument(Instrument i){
		if (cpt==maxTaille) {
			System.out.println("L'orchestre est complet!");
		} else {
			System.out.println(i.toString() + " added");
			tableau[cpt] = i;
			this.cpt += 1;
		}
	}
	
	public void jouer(){
		for (int i=0; i<cpt; i++) {
			tableau[i].jouer();
		}
	}
}
