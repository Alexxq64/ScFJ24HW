package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public final class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonUtil() {
        // Запрещаем создание экземпляра класса
    }

//    // Методы сериализации в JSON
//
//    public static String studentToJson(Student student) {
//        return gson.toJson(student);
//    }
//
//    public static String universityToJson(University university) {
//        return gson.toJson(university);
//    }
//
//    public static String studentListToJson(List<Student> students) {
//        return gson.toJson(students);
//    }
//
//    public static String universityListToJson(List<University> universities) {
//        return gson.toJson(universities);
//    }
//
//    // Методы десериализации из JSON
//
//    public static Student jsonToStudent(String json) {
//        return gson.fromJson(json, Student.class);
//    }
//
//    public static University jsonToUniversity(String json) {
//        return gson.fromJson(json, University.class);
//    }
//
//    public static List<Student> jsonToStudentList(String json) {
//        return gson.fromJson(json, new TypeToken<List<Student>>() {}.getType());
//    }
//
//    public static List<University> jsonToUniversityList(String json) {
//        return gson.fromJson(json, new TypeToken<List<University>>() {}.getType());
//    }
//
//


        // Методы сериализации в JSON

        public static String toJson(Object object) {
            return gson.toJson(object);
        }

        // Методы десериализации из JSON

        public static <T> T fromJson(String json, Class<T> clazz) {
            return gson.fromJson(json, clazz);
        }

        public static <T> List<T> listFromJson(String json, Class<T> clazz) {
            return gson.fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
        }







}