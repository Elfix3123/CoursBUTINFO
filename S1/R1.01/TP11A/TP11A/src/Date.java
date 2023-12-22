public class Date implements Comparable<Date> {
    // 3 attributs de type int : jour, mois, annee
    private int jour;
    private int mois;
    private int annee;

    // constructeur - `À CODER
    public Date(int jour, int mois, int annee){
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    // getters - `À CODER
    public int getJour(){
        return this.jour;
    }

     public int getMois(){
        return this.mois;
    }

    public int getAnnee(){
        return this.annee;
    }
    // this.compareTo(o) > 0 <=> this > o <=> this - o > 0
    @Override
    public int compareTo(Date o) {
        // Ordre choronologique
        if (condition) {
            
        }
    }
    public String toString() {
        // affichage sous la forme jour/mois/annee
        return this.jour + '/' + this.mois + '/' + this.annee;
    }

}
