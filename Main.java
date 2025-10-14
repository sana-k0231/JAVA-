import java.util.*;

class Subject {
    int marks, credits, grade;
}

class Student {
    String usn, name;
    double sgpa;
    Subject sub[] = new Subject[8];
    Scanner sc = new Scanner(System.in);

    Student() {
        for (int i = 0; i < 8; i++)
            sub[i] = new Subject();
    }

    void details() {
        System.out.println("Enter student name:");
        name = sc.nextLine();
        System.out.println("Enter USN:");
        usn = sc.nextLine();
    }

    void getMarks() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Enter marks for subject " + (i + 1) + ":");
            sub[i].marks = sc.nextInt();
            System.out.println("Enter credits for subject " + (i + 1) + ":");
            sub[i].credits = sc.nextInt();

            if (sub[i].marks < 40)
                sub[i].grade = 0;
            else if (sub[i].marks < 50)
                sub[i].grade = 5;
            else if (sub[i].marks < 60)
                sub[i].grade = 6;
            else if (sub[i].marks < 70)
                sub[i].grade = 7;
            else if (sub[i].marks < 80)
                sub[i].grade = 8;
            else if (sub[i].marks < 90)
                sub[i].grade = 9;
            else
                sub[i].grade = 10;
        }
        sc.nextLine(); // Consume the leftover newline
    }

    void calcSgpa() {
        int totalGradeCredits = 0, totalCredits = 0;
        for (int i = 0; i < 8; i++) {
            totalGradeCredits += sub[i].grade * sub[i].credits;
            totalCredits += sub[i].credits;
        }
        sgpa = (double) totalGradeCredits / totalCredits;
    }

    void display() {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.printf("SGPA: %.2f\n", sgpa);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[2];

        for (int i = 0; i < 2; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            students[i] = new Student();
            students[i].details();
            students[i].getMarks();
            students[i].calcSgpa();
        }

        System.out.println("\nStudent Results:");
        for (int i = 0; i < 2; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i].display();
        }

        sc.close();
    }
}