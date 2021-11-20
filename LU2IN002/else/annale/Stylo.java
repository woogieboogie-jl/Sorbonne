public class Stylo {
    private String couleur;
    private int taille;
    public Stylo(String couleur, int taille) {
        this.couleur=couleur;
        this.taille=taille;
    }
    public String toString() {
        return "Stylo "+couleur+" "+taille+" cm";
    }
}
