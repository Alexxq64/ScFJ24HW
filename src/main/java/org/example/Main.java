package org.example;

import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.comparators.UtilComparator;
import org.example.enums.StudentField;
import org.example.enums.UniversityField;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<University> universities = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        String filePath = "/universityInfo.xlsx";
        String studentsSheetName = "Студенты";
        String universitiesSheetName = "Университеты";

        universities = ExcelReader.readUniversities(filePath, universitiesSheetName);
        students = ExcelReader.readStudents(filePath, studentsSheetName);

        // Получение компаратора для сортировки студентов по имени
        StudentComparator studentNameComparator = UtilComparator.getStudentComparator(StudentField.NAME);

        // Получение компаратора для сортировки университетов по ID
        UniversityComparator universityYearComparator = UtilComparator.getUniversityComparator(UniversityField.YEAR);

        // Использование полученных компараторов для сортировки студентов и университетов
        students.sort(studentNameComparator);
        universities.sort(universityYearComparator);

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
}
