package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class XlsReader {
    private static final Logger logger = Logger.getLogger(XlsReader.class.getName());
    private XlsReader() {
    }

    public static List<Student> readStudents(String filePath, String sheetName) {
        List<Student> students = new ArrayList<>();

        try (InputStream inputStream = XlsReader.class.getResourceAsStream(filePath)) {
            assert inputStream != null;
            try (Workbook workbook = new XSSFWorkbook(inputStream)) {

                Sheet sheet = workbook.getSheet(sheetName);

                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);

                    String fullName = row.getCell(1).getStringCellValue();
                    String universityId = row.getCell(0).getStringCellValue();
                    int currentCourseNumber = (int) row.getCell(2).getNumericCellValue();
                    float avgExamScore = (float) row.getCell(3).getNumericCellValue();

                    students.add(new Student(fullName, universityId, currentCourseNumber, avgExamScore));
                }

            }
            logger.info("Successfully read student data from " + filePath);

        } catch (IOException e) {
            logger.severe("Error occurred while reading student data: " + e.getMessage());
        }

        return students;
    }

    public static List<University> readUniversities(String filePath, String sheetName) {
        List<University> universities = new ArrayList<>();

        try (InputStream inputStream = XlsReader.class.getResourceAsStream(filePath)) {
            assert inputStream != null;
            try (Workbook workbook = new XSSFWorkbook(inputStream)) {

                Sheet sheet = workbook.getSheet(sheetName);

                for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                    Row row = sheet.getRow(rowIndex);

                    String id = row.getCell(0).getStringCellValue();
                    String fullName = row.getCell(1).getStringCellValue();
                    String shortName = row.getCell(2).getStringCellValue();
                    int yearOfFoundation = (int) row.getCell(3).getNumericCellValue();
                    StudyProfile mainProfile = StudyProfile.valueOf(row.getCell(4).getStringCellValue());

                    universities.add(new University(id, fullName, shortName, yearOfFoundation, mainProfile));
                }

            }
            logger.info("Successfully read university data from " + filePath);

        } catch (IOException e) {
            logger.severe("Error occurred while reading university data: " + e.getMessage());
        }

        return universities;
    }

}
