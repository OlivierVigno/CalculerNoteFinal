/**
 * Nom de la classe : testSite
 * Description      : représentation d'un étudiant, possédant 2 propriétés, son nom et sa note finale
 * @version         : 1.0
 * Date             : 31/01/2021
 * @author          : Olivier Vigneault
 */

public class Etudiant {
    private String nom;
    private float note;

    Etudiant(String nomEtudiant, float noteEtudiant)
    {
        nom = nomEtudiant;
        note = noteEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public void printInfo()
    {
        System.out.printf("%-24s %15d" ,getNom(), Math.round(getNote()));
    }
}
