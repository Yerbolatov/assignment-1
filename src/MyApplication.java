import models.Person;
import models.Student;
import models.Teacher;
import models.School;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();
        Locale.setDefault(Locale.US);
        File studentsFile = new File("src/students.txt");
        File teachersFile = new File("src/teachers.txt");

        Scanner scStudents = new Scanner(studentsFile);
        Scanner scTeachers = new Scanner(teachersFile);

        while (scStudents.hasNext()) {
            String name = scStudents.next();
            String surname = scStudents.next();
            int age = scStudents.nextInt();
            boolean gender = scStudents.next().equals("Male");

            Student student = new Student(name, surname, age, gender);
            while (scStudents.hasNextInt()) {
                student.addGrade(scStudents.nextInt());
            }

            school.addMember(student);
        }

        while (scTeachers.hasNextLine()) {
            String name = scTeachers.next();
            String surname = scTeachers.next();
            int age = scTeachers.nextInt();
            boolean gender = scTeachers.next().equals("Male");
            String subject = scTeachers.next();
            int yearsOfExperience = scTeachers.nextInt();
            int salary = scTeachers.nextInt();

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);

            school.addMember(teacher);
        }

        for (Person person :school.persons) {
            if (person instanceof Teacher teacher) {
                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10);
                }
            }
        }

        school.sortMembers();

        System.out.println(school);
    }
}