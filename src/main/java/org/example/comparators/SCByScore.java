package org.example.comparators;

import org.example.Student;

import java.util.Comparator;

public class SCByScore implements StudentComparator{
    @Override
    // сравниваем в обратном порядке o2 o1
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }

//    @Override
//    public Comparator<Student> reversed() {
//        return StudentComparator.super.reversed();
//    }

}


