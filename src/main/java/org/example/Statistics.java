package org.example;

import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    private StudyProfile studyProfile;
    @XmlElement(name = "averageScore")
    private float averageScore;
    @XmlTransient
    private int numberOfStudentsByProfile;
    @XmlTransient
    private int numberOfUniversitiesByProfile;
    @XmlTransient
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
