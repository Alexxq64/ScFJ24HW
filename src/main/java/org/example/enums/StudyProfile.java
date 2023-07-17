package org.example.enums;

public enum StudyProfile {
    SCIENCES("Естественные науки"),
    LIBERAL_ARTS("Гуманитарные науки"),
    ENGINEERING("Инженерное дело"),
    CODING("Програмирование"),
    PHYSICS("Физика"),
    FOREIGN_LANGUAGES("Иняз"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Вышка"),
    MEDICINE("Медицина");

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
