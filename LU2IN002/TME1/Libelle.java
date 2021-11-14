//Exercise 13
import java.util.*;

public class Libelle{
    private int n;
    private String s;

    Map<Integer, String> un_dixneuf = new HashMap<Integer, String>() {{
        put(1, "un");
        put(2, "deux");
        put(3, "trois");
        put(4, "quatre");
        put(5, "cinq");
        put(6, "six");
        put(7, "sept");
        put(8, "huit");
        put(9, "neuf");
        put(10, "dix");
        put(11, "onze");
        put(12, "douze");
        put(13, "treize");
        put(14, "quatorze");
        put(15, "quinze");
        put(16, "seize");
        put(17, "dix sept");
        put(18, "dix huit");
        put(19, "dix neuf");
    }};

    Map<Integer, String> vingt_cinquante = new HashMap<Integer, String>() {{
        put(2, "vingt");
        put(3, "trente");
        put(4, "quarante");
        put(5, "cinquante");
    }};

    Map<Integer, String> soixante_quatrevingt = new HashMap<Integer, String>() {{
        put(0, "soixante");
        put(1, "quatre vingt");
    }};

    public Libelle(int n){
        this.n = n;
        this.s = "";
    }

    public Libelle hundredSeperate(){
        if (this.n<100){
            return this;
        } else if ((int)(this.n/100) == 1){
            this.s += "cent ";
            this.n = n%100;
        } else {
            this.s += un_dixneuf.get((int)(this.n/100)) + " cent ";
            this.n = n%100;
        }
        return this;
    }

    public Libelle sixtySeperate(){
        if (this.n<20){
            return this;
        } else if (this.n<60){
            this.s += vingt_cinquante.get((int)(this.n/10)) + " ";;
            this.n = n%10;
            return this;
        } else {
            this.s += soixante_quatrevingt.get((int)((this.n-60)/20)) + " ";
            this.n = (this.n-60)%20;
            return this;
        }
    }
    
    public String twentySeperate(){
        if (this.n == 1 && this.s != ""){
            this.s += "et";
        }
        this.s += un_dixneuf.get((int)this.n);
        return this.s;
    }

    public static void main(String[] args){

        int n = (int)Integer.parseInt(args[0]);
        Libelle l = new Libelle(n);
        l.hundredSeperate();
        l.sixtySeperate();
        String s = l.twentySeperate();
        System.out.println(s);
    }
}