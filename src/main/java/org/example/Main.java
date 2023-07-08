package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static List<University> universities = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws ParseException {


        universities.add(new University("1", "Massachusetts Institute of Technology",
                "MIT", 1861, StudyProfile.ENGINEERING, "United States", "Boston"));
        universities.add(new University("2", "Harvard University",
                "Harvard", 1636, StudyProfile.LIBERAL_ARTS, "United States", "Boston"));
        universities.add(new University("3", "Stanford University",
                "Stanford", 1885, StudyProfile.SCIENCES, "United States", "San Francisco"));
        universities.add(new University("4", "California Institute of Technology",
                "Caltech", 1891, StudyProfile.ENGINEERING, "United States", "Los Angeles"));
        universities.add(new University("5", "Московский государственный университет",
                "МГУ", 1755, StudyProfile.SCIENCES, "Russia", "Moscow"));


        students.add(new Student("Alice Johnson", "1", 3,
                92.0f, parseDate("10.05.2004"), 2018));
        students.add(new Student("Bob Smith", "2", 2,
                85.5f, parseDate("15.09.2005"), 2019));
        students.add(new Student("Emma Davis", "3", 1,
                78.9f, parseDate("22.03.2000"), 2020));
        students.add(new Student("John Williams", "4", 4,
                95.2f, parseDate("05.07.2002"), 2017));
        students.add(new Student("Ольга Портнова", "5", 3,
                88.7f, parseDate("28.11.2001"), 2018));

        System.out.println("Университеты:");
        for (University university : universities) {
            System.out.println(university.toString());
        }
        System.out.println();

        System.out.println("Студенты:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.parse(dateString);
    }

}
