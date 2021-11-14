public class Orchestre{
	private Instrument[] tab;
	private int nbMax;
	static int nbInst;
	
	public Orchestre(int nbInst){
		this.tab = new Instrument[nbInst];
	}

	public void ajouterInstrument(Instrument i){
	if (this.tab.length == nbMax){
		;
	}
	else{
		this.tab[nbInst] = i;
		nbInst++;
	}
	}

	public String jouer() {
		String s="";
		for (int i=0; i<this.tab.length; i++){
			s+= this.tab[i].jouer() + "\n";
		}
		return s;
	}
}
