package com.company;

import java.util.*;

public class Student {
    public String name;
    public int group;
    public List<String> examNames;
    public List<Integer> examMarks;

    public Student(String name, int group, List<String> exams, List<Integer> marks){
        this.name = name;
        this.group = group;
        this.examNames = exams;
        this.examMarks = marks;
    }
}
