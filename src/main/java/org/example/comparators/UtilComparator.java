package org.example.comparators;


import org.example.enums.StudentField;
import org.example.enums.UniversityField;


public class UtilComparator {
    private UtilComparator() {
    }

    public static StudentComparator getStudentComparator(StudentField field) {
        switch (field) {
            case NAME:
                return new SCByName();
            case UNIVERSITY:
                return new SCByUniversity();
            case COURSE:
                return new SCByCourse();
            case SCORE:
                return new SCByScore();
            default:
                throw new IllegalArgumentException("Invalid student field: " + field);
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityField field) {
        switch (field) {
            case ID:
                return new UCByID();
            case NAME:
                return new UCByName();
            case ABBREVIATION:
                return new UCByAbbreviation();
            case YEAR:
                return new UCByYear();
            case PROFILE:
                return new UCByProfile();
            default:
                throw new IllegalArgumentException("Invalid university field: " + field);
        }
    }
}
