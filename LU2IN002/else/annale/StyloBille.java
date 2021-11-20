// ATTENTION : ne pas ajouter "public" devant la signature de la classe
class StyloBille extends Stylo{
    private Bille bille;

    public StyloBille(String couleur, int taille){
        super(couleur, taille);
        this.bille = bille;
    }

    public Bille getBille(){
        return this.bille;
    }

    public String toString(){
        return super.toString() + " avec bille";
    }


}

