package org.example.comparators;

import org.example.Student;
import org.junit.Assert;
import org.junit.Test;

public class SCByScoreTest {

    @Test
    public void testCompare() {
        // Создаем двух студентов с разными средними оценками
        Student student1 = new Student("Иванов Иван", "123", 3, 4.5f);
        Student student2 = new Student("Петров Петр", "456", 2, 3.8f);

        // Создаем экземпляр компаратора SCByScore
        SCByScore comparator = new SCByScore();

        // Проверяем, что сравнение возвращает положительное значение, так как средний балл student1 больше, чем у student2
        Assert.assertTrue(comparator.compare(student1, student2) < 0);

        // Проверяем, что сравнение возвращает отрицательное значение, так как средний балл student2 меньше, чем у student1
        Assert.assertTrue(comparator.compare(student2, student1) > 0);

        // Проверяем, что сравнение возвращает 0, так как средние оценки у студентов равны
        Assert.assertEquals(0, comparator.compare(student1, student1));
    }
}
