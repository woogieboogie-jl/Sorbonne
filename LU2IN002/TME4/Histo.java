public class Histo{
	private int[] hist;

	public Histo(){
		this.hist = new int[21];
		for (int i=0; i < this.hist.length; i++){
			this.hist[i] = 0;
		}
	}

	public Histo(int[] notes){
		this();
		for (int t: notes){
			this.hist[t] += 1;
		}
	}

	public void ajouteNote(int n){
		this.hist[n] += 1;
	}

	public String afficheHistogrammeTableau(){
		String s = "{";
		for (int i=0; i < this.hist.length-1; i++){
			s += hist[i] + ",";
		}
		s += this.hist[this.hist.length-1] + "}";
		return s;
	}

	public String afficheHistogramme(){
		String s = "";
		String r = "";
		for (int i=0; i<this.hist.length; i++){
			for (int j=0; j < this.hist[i]; j++){
				r += "*";
			} 
			s += String.format("%d", i) + " | " + r + "\n";
			r = "";
		}
		return s;
	}
}

