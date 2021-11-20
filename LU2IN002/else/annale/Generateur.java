class Generateur {
	private static int cpt = 10000;

	public String getID(){
		this.cpt += 1;
		return "N" + String.format("%d", this.cpt);
	}

}
