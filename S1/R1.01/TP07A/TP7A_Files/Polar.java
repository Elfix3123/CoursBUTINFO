public class Polar {

    // attributs
    private int annee; // année de première parution de ce Polar
    private String auteur; // auteur de ce Polar
    private String titre; // titre de ce Polar

    // constructeur
    public Polar(int annee, String auteur, String titre) {
        this.annee = annee;
        this.auteur = auteur;
        this.titre = titre;
    }

    // getters
    public int getAnnee() {
        return annee;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

}