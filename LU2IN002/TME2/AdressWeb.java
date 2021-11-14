public class AdressWeb{
	private String protocole;
	private String domaine;
	private String chemin;
	private String url;

	public AdressWeb(String protocole, String domaine, String chemin){
		url = protocole + "://www." + domaine + chemin;
	}
	
	public AdressWeb(String domaine, String chemin){
		url = "https://www." + domaine + chemin;
	}
	public AdressWeb(String domaine){
		url = "https://www." + domaine;
	}
	public String toString(){
		return url;
	}
}
