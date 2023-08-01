package org.example;

import org.example.enums.StudyProfile;

public class Statistics {
    private StudyProfile studyProfile;
    private float averageScore;
    private int numberOfStudentsByProfile;
    private int numberOfUniversitiesByProfile;
    private String universitiesNames;

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = (float) averageScore;
    }

    public int getNumberOfStudentsByProfile() {
        return numberOfStudentsByProfile;
    }

    public void setNumberOfStudentsByProfile(int numberOfStudentsByProfile) {
        this.numberOfStudentsByProfile = numberOfStudentsByProfile;
    }

    public int getNumberOfUniversitiesByProfile() {
        return numberOfUniversitiesByProfile;
    }

    public void setNumberOfUniversitiesByProfile(int numberOfUniversitiesByProfile) {
        this.numberOfUniversitiesByProfile = numberOfUniversitiesByProfile;
    }

    public String getUniversitiesNames() {
        return universitiesNames;
    }

    public void setUniversitiesNames(String universitiesNames) {
        this.universitiesNames = universitiesNames;
    }
}
