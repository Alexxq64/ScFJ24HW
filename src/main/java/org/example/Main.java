package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import static org.example.ExcelReader.readStudents;
//import static org.example.ExcelReader.readUniversities;

public class Main {
    public static List<University> universities = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws ParseException {


        String filePath = "/universityInfo.xlsx";
        String studentsSheetName = "Студенты";
        String universitiesSheetName = "Университеты";

        universities = ExcelReader.readUniversities(filePath, universitiesSheetName);
        students = ExcelReader.readStudents(filePath, studentsSheetName);

        System.out.println("Студенты:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();

        System.out.println("Университеты:");
        for (University university : universities) {
            System.out.println(university);
        }
    }

//    public static Date parseDate(String dateString) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        return dateFormat.parse(dateString);
//    }

}
