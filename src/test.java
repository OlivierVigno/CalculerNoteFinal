/**
 * Nom de la classe : test
 * Description      : classe de test, qui crée une classe d'étudiants et affiches diverses informations à leur sujet.
 * @version         : 1.0
 * Date             : 31/01/2021
 * @author          : Olivier Vigneault
 */
public class test {
    public static void main(String[] args)
    {
        Classe students = new Classe();

        students.readFile("notes.txt");

        students.printStudentGrades();
        students.printStats();
    }
}
