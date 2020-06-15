package com.company;

import java.io.File;
import java.io.IOException;
import java.util.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.*;
import javafx.beans.property.*;
import org.xml.sax.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Controller {
    public ObservableList<Student> tableDataList = FXCollections.observableArrayList();
    public List<Student> allDataList = new ArrayList<>();
    public List<Pair<Student, Integer>> tempDataList = new ArrayList<>();
    private Stage stage;
    TableView<Student> mainTable;
    PageControls pControls;
    DOMParser parser = new DOMParser();

    public Controller(Stage mainStage){
        this.stage = mainStage;
    }

    public TableView<Student> genMainTable(){
        this.mainTable = new TableView<>();
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().name);
            }
        });

        TableColumn<Student, String> groupColumn = new TableColumn<>("Group");
        groupColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().group);
                return new SimpleStringProperty(s);
            }
        });

        TableColumn<Student, String> examsColumn = new TableColumn<>("Exams");

        TableColumn<Student, String> exam1 = new TableColumn<>("1");
        TableColumn<Student, String> exam2 = new TableColumn<>("2");
        TableColumn<Student, String> exam3 = new TableColumn<>("3");
        TableColumn<Student, String> exam4 = new TableColumn<>("4");
        TableColumn<Student, String> exam5 = new TableColumn<>("5");

        TableColumn<Student, String> examN1 = new TableColumn<>("Exam name");
        examN1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(0));
            }
        });
        TableColumn<Student, String> examN2 = new TableColumn<>("Exam name");
        examN2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(1));
            }
        });
        TableColumn<Student, String> examN3 = new TableColumn<>("Exam name");
        examN3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(2));
            }
        });
        TableColumn<Student, String> examN4 = new TableColumn<>("Exam name");
        examN4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(3));
            }
        });
        TableColumn<Student, String> examN5 = new TableColumn<>("Exam name");
        examN5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(4));
            }
        });

        TableColumn<Student, String> examM1 = new TableColumn<>("Mark");
        examM1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(0));
                return new SimpleStringProperty(s);
            }
        });
        TableColumn<Student, String> examM2 = new TableColumn<>("Mark");
        examM2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(1));
                return new SimpleStringProperty(s);
            }
        });
        TableColumn<Student, String> examM3 = new TableColumn<>("Mark");
        examM3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(2));
                return new SimpleStringProperty(s);
            }
        });
        TableColumn<Student, String> examM4 = new TableColumn<>("Mark");
        examM4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(3));
                return new SimpleStringProperty(s);
            }
        });
        TableColumn<Student, String> examM5 = new TableColumn<>("Mark");
        examM5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(4));
                return new SimpleStringProperty(s);
            }
        });

        exam1.getColumns().addAll(examN1, examM1);
        exam2.getColumns().addAll(examN2, examM2);
        exam3.getColumns().addAll(examN3, examM3);
        exam4.getColumns().addAll(examN4, examM4);
        exam5.getColumns().addAll(examN5, examM5);

        examsColumn.getColumns().addAll(exam1, exam2, exam3, exam4, exam5);

        mainTable.getColumns().addAll(nameColumn, groupColumn, examsColumn);

        mainTable.setItems(tableDataList);
        return mainTable;
    }

    public TableView<Student> genDeleteTable(){
        TableView<Student> delTable = new TableView<>();
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().name);
            }
        });

        TableColumn<Student, String> groupColumn = new TableColumn<>("Group");
        groupColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().group);
                return new SimpleStringProperty(s);
            }
        });

        TableColumn<Student, String> examsColumn = new TableColumn<>("Exams");

        TableColumn<Student, String> exam1 = new TableColumn<>("1");
        TableColumn<Student, String> exam2 = new TableColumn<>("2");
        TableColumn<Student, String> exam3 = new TableColumn<>("3");
        TableColumn<Student, String> exam4 = new TableColumn<>("4");
        TableColumn<Student, String> exam5 = new TableColumn<>("5");

        TableColumn<Student, String> examN1 = new TableColumn<>("Exam name");
        examN1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(0));
            }
        });
        TableColumn<Student, String> examN2 = new TableColumn<>("Exam name");
        examN2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(1));
            }
        });
        TableColumn<Student, String> examN3 = new TableColumn<>("Exam name");
        examN3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(2));
            }
        });
        TableColumn<Student, String> examN4 = new TableColumn<>("Exam name");
        examN4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(3));
            }
        });
        TableColumn<Student, String> examN5 = new TableColumn<>("Exam name");
        examN5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().examNames.get(4));
            }
        });

        TableColumn<Student, String> examM1 = new TableColumn<>("Mark");
        examM1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(0));
                return new SimpleStringProperty(s);
            }
        });
        TableColumn<Student, String> examM2 = new TableColumn<>("Mark");
        examM2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(1));
                return new SimpleStringProperty(s);
            }
        });
        TableColumn<Student, String> examM3 = new TableColumn<>("Mark");
        examM3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(2));
                return new SimpleStringProperty(s);
            }
        });
        TableColumn<Student, String> examM4 = new TableColumn<>("Mark");
        examM4.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(3));
                return new SimpleStringProperty(s);
            }
        });
        TableColumn<Student, String> examM5 = new TableColumn<>("Mark");
        examM5.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                String s = Integer.toString(param.getValue().examMarks.get(4));
                return new SimpleStringProperty(s);
            }
        });

        exam1.getColumns().addAll(examN1, examM1);
        exam2.getColumns().addAll(examN2, examM2);
        exam3.getColumns().addAll(examN3, examM3);
        exam4.getColumns().addAll(examN4, examM4);
        exam5.getColumns().addAll(examN5, examM5);

        examsColumn.getColumns().addAll(exam1, exam2, exam3, exam4, exam5);

        delTable.getColumns().addAll(nameColumn, groupColumn, examsColumn);

        //mainTable.setItems(tableDataList);
        return delTable;
    }

    public void showAlertSomeFieldsAreEmpty(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Some fields are empty!");

        alert.showAndWait();
    }

    public List<Pair<Student, Integer>> searchByGroup(Student stud){
        List<Pair<Student, Integer>> list = new ArrayList<>();
        for(Student t : allDataList){
            if(t.group == stud.group){
                list.add(new Pair<>(t, allDataList.indexOf(t)));
            }
        }
        //list = searchByMark(stud, list);
        return searchByMark(stud, list);
    }

    public List<Pair<Student, Integer>> searchByMark(Student stud, List<Pair<Student, Integer>> list){
        for(Student t : allDataList){
            List<String> temp = t.examNames;
            if(temp.contains(stud.examNames.get(0))){
                int i = temp.indexOf(stud.examNames.get(0));
                int min = stud.examMarks.get(0);
                int max = stud.examMarks.get(1);
                int mark = t.examMarks.get(i);
                if(mark >= min && mark <= max){
                    list.add(new Pair<>(t, allDataList.indexOf(t)));
                }
            }
        }
        //list = searchByMid(stud, list);
        return searchByMid(stud, list);
    }

    public List<Pair<Student, Integer>> searchByMid(Student stud, List<Pair<Student, Integer>> list){
        for(Student t : allDataList){
            List<String> temp = t.examNames;
            if(temp.contains(stud.examNames.get(1))){
                int i = temp.indexOf(stud.examNames.get(1));
                int min = stud.examMarks.get(2);
                int max = stud.examMarks.get(3);
                int mark = 0;
                List<Integer> ntemp = t.examMarks;
                for(Integer j : ntemp) {
                    mark += ntemp.get(i);
                }
                mark /= 5;
                if(mark >= min && mark <= max){
                    list.add(new Pair<>(t, allDataList.indexOf(t)));
                }
            }
        }
        //list = compareResults(list);
        return compareResults(list);
    }

    public List<Pair<Student, Integer>> compareResults(List<Pair<Student, Integer>> list){
        List<Pair<Student, Integer>> newList = new ArrayList<>();
        newList.add(list.get(0));
        for(Pair<Student, Integer> p : list){
            if(!newList.contains(p)){
                newList.add(p);
            }
        }
        return newList;
    }

    public void deleteResults(List<Pair<Student, Integer>> list){
        for(Pair<Student, Integer> p : list){
            allDataList.remove(p.getKey());
        }
        refreshTable();
    }

    public void setPageControls(PageControls controls){
        this.pControls = controls;
    }

    public void refreshTable(){
        tableDataList.clear();
        int num = pControls.getPageNumber();
        int n = pControls.getPageCount();
        for(int i = 0; i < n; i++){
            if(allDataList.size() == i){
                break;
            }
            if(!((i + (num - 1) * n) >= allDataList.size())) {
                tableDataList.add(allDataList.get(i + (num - 1) * n));
            } else if(tableDataList.size() == 0){
                pageDown();
            }
        }
        mainTable.refresh();
    }

    public void pageUp(){
        pControls.setPageNumber(pControls.getPageNumber() + 1);
        refreshTable();
    }

    public void pageDown(){
        if(!(pControls.getPageNumber() == 1)) {
            pControls.setPageNumber(pControls.getPageNumber() - 1);
            refreshTable();
        }
    }

    public void firstPage(){
        pControls.setPageNumber(1);
        refreshTable();
    }

    public void lastPage(){
        while(tableDataList.size() >= pControls.getPageCount()){
            pageUp();
        }
        refreshTable();
    }

    public void saveTableData(File file) throws TransformerException, ParserConfigurationException {
        parser.parse(allDataList, file);
    }

    public void getTableDataFromFile(File file, SAXParser parser) throws ParserConfigurationException, SAXException,
            IOException {
        SAXparser saxParser = new SAXparser();

        SAXParserFactory factory = SAXParserFactory.newInstance();

        parser = factory.newSAXParser();
        parser.parse(file, saxParser);

        allDataList = saxParser.getStudents();
        /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText("Records loaded, refresh table to view records.");
        alert.showAndWait();*/
    }
}
