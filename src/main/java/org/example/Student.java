package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;


public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;


    private LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }


    public Student(String fullName, String universityId, int currentCourseNumber,
                   float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return String.format("%-25s %-10s course %d.       Average: %.2f", fullName,
                (getUniversityShortName(universityId) + ','), currentCourseNumber, avgExamScore);
    }



    private String getUniversityShortName(String universityId) {
        for (University university : Main.universities) {
            if (university.getId().equals(universityId)) {
                return university.getShortName();
            }
        }
        return null; // Or any default value if universityId is not found
    }

}
