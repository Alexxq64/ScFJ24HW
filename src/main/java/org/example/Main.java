package org.example;

import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.comparators.UtilComparator;
import org.example.enums.StudentField;
import org.example.enums.UniversityField;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<University> universities = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        String filePath = "/universityInfo.xlsx";
        String studentsSheetName = "Студенты";
        String universitiesSheetName = "Университеты";

        universities = ExcelReader.readUniversities(filePath, universitiesSheetName);
        students = ExcelReader.readStudents(filePath, studentsSheetName);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сортировка университетов:");
        System.out.println("[1] ID   [2] название   [3] сокращение   [4] год основания   [5] профиль");
        System.out.println("Выберите пункт меню: ");

        int choice = scanner.nextInt();
        if (choice > UniversityField.values().length || choice < 1) {
            choice = 1;
            System.out.println("Нет такого пункта. Сортировка проводится по ID.");
        }
        UniversityComparator unCmp = UtilComparator.getUniversityComparator(UniversityField.values()[choice - 1]);

        System.out.println("                  университет                                                      год основания         профиль");
        universities.stream()
                .sorted(unCmp)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Сортировка студентов:");
        System.out.println("[1] ФИО   [2] университет   [3] курс   [4] оценки");
        System.out.println("Выберите пункт меню: ");

        choice = scanner.nextInt();
        if (choice > StudentField.values().length || choice < 1) {
            choice = 1;
            System.out.println("Нет такого пункта. Сортировка проводится по фамилии.");
        }
        StudentComparator stCmp = UtilComparator.getStudentComparator(StudentField.values()[choice - 1]);

        System.out.println("  студент              университет   курс   средний бал");
        students.stream()
                .sorted(stCmp)
                .forEach(System.out::println);

    }
}
