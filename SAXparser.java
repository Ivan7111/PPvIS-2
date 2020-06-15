package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class SAXparser extends DefaultHandler {

    private List<Student> students = new ArrayList<>();
    private String thisElement = "";
    private String studentName = "";
    private int studentGroup;
    private String e1 = "";
    private String e2 = "";
    private String e3 = "";
    private String e4 = "";
    private String e5 = "";
    private int m1;
    private int m2;
    private int m3;
    private int m4;
    private int m5;
    private int readCounter = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (thisElement) {
            case "studentName":
                studentName = new String(ch, start, length);
                break;
            case "studentGroup":
                String studentGroupString = new String(ch, start, length);
                studentGroup = Integer.parseInt(studentGroupString);
                break;
            case "ekzName1":
                e1 = new String(ch, start, length);
                break;
            case "ekzName2":
                e2 = new String(ch, start, length);
                break;
            case "ekzName3":
                e3 = new String(ch, start, length);
                break;
            case "ekzName4":
                e4 = new String(ch, start, length);
                break;
            case "ekzName5":
                e5 = new String(ch, start, length);
                break;
            case "ekzMark1":
                String sm1 = new String(ch, start, length);
                m1 = Integer.parseInt(sm1);
                break;
            case "ekzMark2":
                String sm2 = new String(ch, start, length);
                m2 = Integer.parseInt(sm2);
                break;
            case "ekzMark3":
                String sm3 = new String(ch, start, length);
                m3 = Integer.parseInt(sm3);
                break;
            case "ekzMark4":
                String sm4 = new String(ch, start, length);
                m4 = Integer.parseInt(sm4);
                break;
            case "ekzMark5":
                String sm5 = new String(ch, start, length);
                m5 = Integer.parseInt(sm5);
                break;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        readCounter++;
        if (readCounter == 13) {
            List<String> exams = new ArrayList<>();
            exams.add(e1);
            exams.add(e2);
            exams.add(e3);
            exams.add(e4);
            exams.add(e5);
            List<Integer> marks = new ArrayList<>();
            marks.add(m1);
            marks.add(m2);
            marks.add(m3);
            marks.add(m4);
            marks.add(m5);
            students.add(new Student(studentName, studentGroup, exams, marks));
            readCounter = 0;
        }
        thisElement = "";
    }

    public List<Student> getStudents() {
        return students;
    }
}
