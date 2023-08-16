package org.example;

import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.comparators.UtilComparator;
import org.example.enums.StudentField;
import org.example.enums.UniversityField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import java.io.IOException;

public class Main {

    public static List<University> universities = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        logger.info("Application started");

        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));


        String filePath = "/universityInfo.xlsx";
        String studentsSheetName = "Студенты";
        String universitiesSheetName = "Университеты";

        universities = ExcelReader.readUniversities(filePath, universitiesSheetName);
        students = ExcelReader.readStudents(filePath, studentsSheetName);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.generateAndWriteTable(statisticsList, "statistics.xlsx");


        Scanner scanner = new Scanner(System.in);

        System.out.println("Сортировка университетов:");
        System.out.println("[1] ID   [2] название   [3] сокращение   [4] год основания   [5] профиль");
        System.out.println("Выберите пункт меню: ");

        int choice = scanner.nextInt();
        if (choice > UniversityField.values().length || choice < 1) {
            choice = 1;
            logger.warning("No such item. Sorted by ID.");
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
            logger.warning("No such item. Sorted by name");
        }
        StudentComparator stCmp = UtilComparator.getStudentComparator(StudentField.values()[choice - 1]);

        System.out.println("  студент              университет   курс   средний бал");
        students.stream()
                .sorted(stCmp)
                .forEach(System.out::println);

        String universitiesJson = JsonUtil.toJson(universities);
        String studentsJson = JsonUtil.toJson(students);

//        System.out.println("\nJSON университетов:");
//        System.out.println(universitiesJson);
//
//        System.out.println("\nJSON студентов:");
//        System.out.println(studentsJson);

        List<University> newUniversities = JsonUtil.listFromJson(universitiesJson, University.class);
        List<Student> newStudents = JsonUtil.listFromJson(studentsJson, Student.class);

//        System.out.println("\nУниверситеты, восстановленные из JSON:");
//        newUniversities.forEach(System.out::println);
//
//        System.out.println("\nСтуденты, восстановленные из JSON:");
//        newStudents.forEach(System.out::println);


        List<String> universitiesJsonList = universities.stream()
                .map(JsonUtil::toJson)
                .collect(Collectors.toList());

        List<String> studentsJsonList = students.stream()
                .map(JsonUtil::toJson)
                .collect(Collectors.toList());

//        System.out.println("\nJSON университетов:");
//        universitiesJsonList.forEach(System.out::println);
//
//        System.out.println("\nJSON студентов:");
//        studentsJsonList.forEach(System.out::println);

        List<University> newUniversitiesList = universitiesJsonList.stream()
                .map(json -> JsonUtil.fromJson(json, University.class))
                .collect(Collectors.toList());

        List<Student> newStudentsList = studentsJsonList.stream()
                .map(json -> JsonUtil.fromJson(json, Student.class))
                .collect(Collectors.toList());

//        System.out.println("\nНовые университеты:");
//        newUniversitiesList.forEach(System.out::println);
//
//        System.out.println("\nНовые студенты:");
//        newStudentsList.forEach(System.out::println);

        DataSet dataSet = new DataSet()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setExecDate(new Date());

// ???????????????????????????????????????????????
        XmlWriter.writeToXml(dataSet);

        DataSetJsonWriter.writeDataSetToJsonFile(dataSet);


        logger.info("Application finished");
    }
}
