import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Collections;
import java.lang.Math;

/**
 * Nom de la classe : Classe
 * Description      : ensemble d'étudiant permettant d'effectuer divers calculs et d'afficher diverses informations par rapport aux résultats des étudiants (notes)
 * @version         : 1.0
 * Date             : 31/01/2021
 * @author          : Olivier Vigneault
 */
public class Classe {
    ArrayList<Etudiant> etudiants;

    Classe()
    {
        etudiants = new ArrayList<Etudiant>();
    }

    public void readFile(String fileName)
    {
        Scanner scanner = null;
        try {
            File notes = new File(fileName);
            scanner = new Scanner(notes);
            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String[] data = line.split("\\s");
                String name = data[0];
                float note = Float.parseFloat(data[1]);
                etudiants.add(new Etudiant(name, note));
            }

            for (int i = 0; i < (etudiants.size() - 1); i++)
            {
                for(int j = i + 1; j < etudiants.size(); j++)
                {
                    if(etudiants.get(i).getNom().compareTo(etudiants.get(j).getNom()) > 0)
                        Collections.swap(etudiants, i, j);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Le fichier n'a pas été trouvé.");
        }
        finally
        {
            scanner.close();
        }
    }

    public int getFailuresNumber()
    {
        int echecs = 0;
        for (Etudiant etudiant : etudiants)
        {
            if (etudiant.getNote() < 60)
            {
                echecs++;
            }
        }
        return echecs;
    }

    public float getAverageGrade()
    {
        int somme = 0;

        for (Etudiant etudiant : etudiants)
        {
            somme += Math.round(etudiant.getNote());
        }
        return (float) somme / etudiants.size();
    }

    public String bestStudentName()
    {
        String nomEtudiant = "";
        float meilleureNote = 0;

        for (Etudiant etudiant : etudiants)
        {
            if (etudiant.getNote() > meilleureNote)
            {
                meilleureNote = etudiant.getNote();
                nomEtudiant = etudiant.getNom();
            }
        }

        return nomEtudiant;
    }

    public int getStudentAboveAverage()
    {
        float average = getAverageGrade();
        int numberOfStudent = 0;

        for(Etudiant etudiant : etudiants)
        {
            if (etudiant.getNote() >= average)
                numberOfStudent++;
        }
        return numberOfStudent;
    }

    public void printStudentGrades()
    {
        for (Etudiant etudiant : etudiants)
        {
            System.out.println(etudiant + ((etudiant.getNote() < 60) ? " EC" : ""));
        }
    }
    public void printStats()
    {
        System.out.printf("%-35s %5d %s", "\nnombre total d'étudiant : ", etudiants.size(), "\n");
        System.out.printf("%-35s %4d %s", "Nombre d'échec : ", getFailuresNumber(), "\n");
        System.out.printf("%-35s %7.1f %s", "Moyenne du groupe : ", getAverageGrade(), "\n");
        System.out.printf("%-35s %8s %s", "Meilleur(e) étudiant(e) : ", bestStudentName(), "\n");
        System.out.printf("%-35s %3d %s", "Nb. d'étudiants sup. à la moyenne : ", getStudentAboveAverage(), "\n");
    }



}
