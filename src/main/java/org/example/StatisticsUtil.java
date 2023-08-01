package org.example;

import org.apache.commons.lang3.StringUtils;
import org.example.enums.StudyProfile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatisticsUtil {

    private StatisticsUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = new HashSet<>();
        universities.forEach(university -> profiles.add(university.getMainProfile()));

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statistics.setStudyProfile(profile);

            List<String> profileUniversityIds = new ArrayList<>();
            universities.stream()
                    .filter(university -> university.getMainProfile() == profile)
                    .forEach(university -> profileUniversityIds.add(university.getId()));

            statistics.setNumberOfUniversitiesByProfile(profileUniversityIds.size());
            statistics.setUniversitiesNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getShortName)
                    .forEach(shortNameUniversity -> statistics.setUniversitiesNames(
                            statistics.getUniversitiesNames() + shortNameUniversity + ", "));

            List<Student> profileStudents = new ArrayList<>();
            students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .forEach(profileStudents::add);

            statistics.setNumberOfStudentsByProfile(profileStudents.size());
            double avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average()
                    .orElse(0);
            statistics.setAverageScore(BigDecimal.valueOf(avgExamScore).setScale(2, RoundingMode.HALF_UP).doubleValue());

            statisticsList.add(statistics);
        });

        return statisticsList;
    }
}