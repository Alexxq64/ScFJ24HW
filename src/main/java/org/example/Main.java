package org.example;

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

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.generateAndWriteTable(statisticsList, "statistics.xlsx");


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Сортировка университетов:");
//        System.out.println("[1] ID   [2] название   [3] сокращение   [4] год основания   [5] профиль");
//        System.out.println("Выберите пункт меню: ");
//
//        int choice = scanner.nextInt();
//        if (choice > UniversityField.values().length || choice < 1) {
//            choice = 1;
//            System.out.println("Нет такого пункта. Сортировка проводится по ID.");
//        }
//        UniversityComparator unCmp = UtilComparator.getUniversityComparator(UniversityField.values()[choice - 1]);
//
//        System.out.println("                  университет                                                      год основания         профиль");
//        universities.stream()
//                .sorted(unCmp)
//                .forEach(System.out::println);
//
//        System.out.println();
//
//        System.out.println("Сортировка студентов:");
//        System.out.println("[1] ФИО   [2] университет   [3] курс   [4] оценки");
//        System.out.println("Выберите пункт меню: ");
//
//        choice = scanner.nextInt();
//        if (choice > StudentField.values().length || choice < 1) {
//            choice = 1;
//            System.out.println("Нет такого пункта. Сортировка проводится по фамилии.");
//        }
//        StudentComparator stCmp = UtilComparator.getStudentComparator(StudentField.values()[choice - 1]);
//
//        System.out.println("  студент              университет   курс   средний бал");
//        students.stream()
//                .sorted(stCmp)
//                .forEach(System.out::println);
//
//        // Сериализация и вывод в консоль
//        String universitiesJson = JsonUtil.universityListToJson(universities);
//        String studentsJson = JsonUtil.studentListToJson(students);
//
//        System.out.println("\nJSON университетов:");
//        System.out.println(universitiesJson);
//
//        System.out.println("\nJSON студентов:");
//        System.out.println(studentsJson);
//
//        // Десериализация и сохранение в новые коллекции
//        List<University> newUniversities = JsonUtil.jsonToUniversityList(universitiesJson);
//        List<Student> newStudents = JsonUtil.jsonToStudentList(studentsJson);
//
//        // Вывод новых коллекций для проверки
//        System.out.println("\nУниверситеты, восстановленные из JSON:");
//        newUniversities.forEach(System.out::println);
//
//        System.out.println("\nСтуденты, восстановленные из JSON:");
//        newStudents.forEach(System.out::println);
//
//
//        List<String> universitiesJsonList = universities.stream()
//                .map(JsonUtil::universityToJson)
//                .collect(Collectors.toList());
//
//        List<String> studentsJsonList = students.stream()
//                .map(JsonUtil::studentToJson)
//                .collect(Collectors.toList());
//
//        System.out.println("\nJSON университетов:");
//        universitiesJsonList.forEach(System.out::println);
//
//        System.out.println("\nJSON студентов:");
//        studentsJsonList.forEach(System.out::println);
//
//        // Десериализация и сохранение в новые коллекции
//        List<University> newUniversitiesList = universitiesJsonList.stream()
//                .map(JsonUtil::jsonToUniversity)
//                .collect(Collectors.toList());
//
//        List<Student> newStudentsList = studentsJsonList.stream()
//                .map(JsonUtil::jsonToStudent)
//                .collect(Collectors.toList());
//
//        // Вывод новых коллекций для проверки
//        System.out.println("\nНовые университеты:");
//        newUniversitiesList.forEach(System.out::println);
//
//        System.out.println("\nНовые студенты:");
//        newStudentsList.forEach(System.out::println);
//
//

    }
}
