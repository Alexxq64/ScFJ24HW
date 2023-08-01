package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;


public class XlsWriter {

    private XlsWriter() {
    }

    public static void generateAndWriteTable(List<Statistics> statisticsList, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Statistics");

            DecimalFormat decimalFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));

            CellStyle headerStyle = createHeaderStyle(workbook);
            CellStyle dataStyle = createDataStyle(workbook);

            String[] headers = {"Профиль", "Средняя оценка", "Кол-во студентов", "Кол-во университетов", "Названия университетов"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }

            for (int rowIndex = 0; rowIndex < statisticsList.size(); rowIndex++) {
                Row dataRow = sheet.createRow(rowIndex + 1);
                Statistics statistics = statisticsList.get(rowIndex);

                dataRow.createCell(0).setCellValue(statistics.getStudyProfile().toString());
                String formattedAverageScore = decimalFormat.format(statistics.getAverageScore());
                dataRow.createCell(1).setCellValue(formattedAverageScore);
                dataRow.createCell(2).setCellValue(statistics.getNumberOfStudentsByProfile());
                dataRow.createCell(3).setCellValue(statistics.getNumberOfUniversitiesByProfile());
                String names = statistics.getUniversitiesNames();
                if (!names.isEmpty()) {
                    names = names.substring(0, names.length() - 2) + ".";
                }
                dataRow.createCell(4).setCellValue(names);

                for (int i = 0; i < headers.length; i++) {
                    dataRow.getCell(i).setCellStyle(dataStyle);
                }
            }

            for (int columnIndex = 0; columnIndex < headers.length; columnIndex++) {
                sheet.autoSizeColumn(columnIndex);
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            System.out.println("Table generated and written to the file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error occurred while generating and writing the table: " + e.getMessage());
        }
    }

    private static CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle headerStyle = workbook.createCellStyle();

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setWrapText(true);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        setThinBorders(headerStyle);

        return headerStyle;
    }

    private static CellStyle createDataStyle(Workbook workbook) {
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setWrapText(true);
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        setThinBorders(dataStyle);

        return dataStyle;
    }

    private static void setThinBorders(CellStyle style) {
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
    }
}
