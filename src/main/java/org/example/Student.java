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
    private Date birthDate;
    private int admissionYear;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }


    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthLocalDate = convertToLocalDate(birthDate);

        return Period.between(birthLocalDate, currentDate).getYears();
    }

    private LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }


    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore, Date birthDate, int admissionYear) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
        this.birthDate = birthDate;
        this.admissionYear = admissionYear;
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
        return String.format("%-35s %-10s course %d. Average: %.2f", (fullName + ", " + getAge()),
                (getUniversityShortName(universityId) + ','), currentCourseNumber, avgExamScore);
    }

    public String getUniversityShortName(String universityId) {
        for (University university : Main.universities) {
            if (university.getId().equals(universityId)) {
                return university.getShortName();
            }
        }

        return null; // Или любое значение по умолчанию, если universityId не найден
    }
}
