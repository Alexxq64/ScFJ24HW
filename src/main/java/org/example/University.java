package org.example;

public class University {
    private String id;
    private String fullName;
    private String shortName;
    private int yearOfFoundation;
    private StudyProfile mainProfile;
    private String country;
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public University(String id, String fullName, String shortName,
                      int yearOfFoundation, StudyProfile mainProfile, String country, String city) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
        this.country = country;
        this.city = city;
    }

    // Дополнительные геттеры и сеттеры

    // ...



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
//    public String toString() {
//        return  id + ".   " + fullName + " " +
//                " (" + shortName + ") " +
//                " " + yearOfFoundation + ". " +
//                country + ", " + city +
//                ".   Profile: " + mainProfile.getProfileName();
//    }

    public String toString() {
        return String.format("%-5s%-40s - %-10s  %-4d. %15s, %-15s Profile: %s", id, fullName, shortName, yearOfFoundation, country, city, mainProfile.getProfileName());
    }

}
