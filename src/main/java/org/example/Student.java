package org.example;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("sFullName")
    private String fullName;

    @SerializedName("sUniversityId")
    private String universityId;

    @SerializedName("sCurrentCourseNumber")
    private int currentCourseNumber;

    @SerializedName("sAvgExamScore")
    private float avgExamScore;

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
        return String.format("%-25s %-10s   %d        %.2f", fullName,
                getUniversityShortName(universityId), currentCourseNumber, avgExamScore);
    }



    private String getUniversityShortName(String universityId) {
        for (University university : Main.universities) {
            if (university.getId().equals(universityId)) {
                return university.getShortName();
            }
        }
        return null; // Or any default value if universityId was not found
    }

}
