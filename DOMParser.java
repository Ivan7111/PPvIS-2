package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class DOMParser {

    public void parse(List<Student> tableData, File file) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document document = docBuilder.newDocument();
        Element docRootElement = document.createElement("tableData");

        for (int index = 0; index < tableData.size(); index++) {
            docRootElement.appendChild(addStudentToDocument(index, tableData.get(index), document));
        }

        document.appendChild(docRootElement);
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        saveDataInFile(source, result);
    }

    private Element addStudentToDocument(int index, Student student, Document document) {

        Element studentItem = document.createElement("student");
        studentItem.setAttribute("number", Integer.toString(index));
        document.appendChild(studentItem);

        Element studentName = document.createElement("studentName");
        studentName.appendChild(document.createTextNode(student.name));
        studentItem.appendChild(studentName);

        Element studentGroup = document.createElement("studentGroup");
        int gr = student.group;
        studentGroup.appendChild(document.createTextNode(Integer.toString(gr)));
        studentItem.appendChild(studentGroup);

        Element ekzName1 = document.createElement("ekzName1");
        ekzName1.appendChild(document.createTextNode(student.examNames.get(0)));
        studentItem.appendChild(ekzName1);

        Element ekzMark1 = document.createElement("ekzMark1");
        int m = student.examMarks.get(0);
        ekzMark1.appendChild(document.createTextNode(Integer.toString(m)));
        studentItem.appendChild(ekzMark1);

        Element ekzName2 = document.createElement("ekzName2");
        ekzName2.appendChild(document.createTextNode(student.examNames.get(1)));
        studentItem.appendChild(ekzName2);

        Element ekzMark2 = document.createElement("ekzMark2");
        m = student.examMarks.get(1);
        ekzMark2.appendChild(document.createTextNode(Integer.toString(m)));
        studentItem.appendChild(ekzMark2);

        Element ekzName3 = document.createElement("ekzName3");
        ekzName3.appendChild(document.createTextNode(student.examNames.get(2)));
        studentItem.appendChild(ekzName3);

        Element ekzMark3 = document.createElement("ekzMark3");
        m = student.examMarks.get(2);
        ekzMark3.appendChild(document.createTextNode(Integer.toString(m)));
        studentItem.appendChild(ekzMark3);

        Element ekzName4 = document.createElement("ekzName4");
        ekzName4.appendChild(document.createTextNode(student.examNames.get(3)));
        studentItem.appendChild(ekzName4);

        Element ekzMark4 = document.createElement("ekzMark4");
        m = student.examMarks.get(3);
        ekzMark4.appendChild(document.createTextNode(Integer.toString(m)));
        studentItem.appendChild(ekzMark4);

        Element ekzName5 = document.createElement("ekzName5");
        ekzName5.appendChild(document.createTextNode(student.examNames.get(4)));
        studentItem.appendChild(ekzName5);

        Element ekzMark5 = document.createElement("ekzMark5");
        m = student.examMarks.get(4);
        ekzMark5.appendChild(document.createTextNode(Integer.toString(m)));
        studentItem.appendChild(ekzMark5);

        return studentItem;
    }

    private void saveDataInFile(DOMSource source, StreamResult result) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }
}