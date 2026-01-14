package Oppg_1_1;

// LesStudenter.java
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// 1. Definere en klasse for data fra en datafil om studenter basert på strukturen i data (se oppgavetekst i README.md)
// Velg egnede typer for felt i filen med studentinfo, f.eks. første felt kan være en int, siden den representerer id
// eller studentnummer. Andre felt, som representerer navn til studenten, kan være en String, for eksempel, osv.
class Student {
    int id;
    String name;
    String program;

    public Student(int id, String name, String program){
        this.id = id;
        this.name = name;
        this.program = program;
    }

    @Override
    public String toString(){
        return "Student{id=" + id + ", " +
                "navn='" + name + "', program='" + program +  "'}";
    }
}

// 2. Bruk try-with-resources for sikker filbehandling og les inn data fra fil i en Java datastruktur
// ved bruk av Scanner, linje for linje, og til slutt skriv ut datafeltene til
// stdout(System.out i Java)
public class LesStudenter {
    public static void main(String[] args) {
        //try (Scanner leser = new Scanner(new File(args[0]))){
        try (Scanner leser = new Scanner(new File("C:\\Users\\ingas\\Desktop\\fil-som-database-KokosMjolkeKua\\oppgave1\\studenter.csv"))){
            while (leser.hasNext()) {
                String[] student = leser.nextLine().split(",");
                if(student.length == 3){
                    Student s = new Student(Integer.parseInt(student[0].trim()), student[1].trim(), student[2].trim());
                    System.out.println(s.toString());
                }
            }
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
    }
}

/** Output skal være:
 Student{id=101, navn='Mickey', program='CS'}
 Student{id=102, navn='Daffy', program='EE'}
 Student{id=103, navn='Donald', program='CS'}
 Student{id=104, navn='Minnie', program='PSY'}
 */

