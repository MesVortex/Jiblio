public class Livre {
    private String titre;
    private String auteur;
    private int annee;

    public Livre() {
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void afficher() {
        System.out.printf("Auteur: " + getAuteur() +
                " Titre: " + getTitre() +
                " Annee: " + getAnnee() + "\n");
    }
    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", annee=" + annee +
                '}';
    }
}
