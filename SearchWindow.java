package com.company;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.*;

public class SearchWindow {
    private Stage stage;
    private Controller controller;

    public SearchWindow(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;

        VBox vBox = getSearchLayout();

        Scene scene = new Scene(vBox);
        Stage newStage = new Stage();
        newStage.setTitle("Searching for:");
        newStage.initOwner(stage);
        newStage.setScene(scene);
        newStage.showAndWait();
    }

    public VBox getSearchLayout(){
        VBox vBox = new VBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();

        List<String> exams = new ArrayList<>();
        exams.add("Math");
        exams.add("Programming");
        exams.add("English");
        exams.add("Belorussian");
        exams.add("History");
        exams.add("Philosophy");
        exams.add("Discrete Math");
        exams.add("Data Protection");

        Label group = new Label("Group");
        TextField groupField = new TextField();

        ComboBox<String> ekz1 = new ComboBox<>();
        ekz1.getItems().addAll(exams);
        Label min1 = new Label("Min mark");
        TextField ekzFieldMin = new TextField();
        Label max1 = new Label("Max mark");
        TextField ekzFieldMax = new TextField();

        ComboBox<String> ekz2 = new ComboBox<>();
        ekz2.getItems().addAll(exams);
        Label min2 = new Label("Min mark");
        TextField ekzField2Min = new TextField();
        Label max2 = new Label("Max mark");
        TextField ekzField2Max = new TextField();

        Button save = new Button("Search");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!(groupField.getText().equals("") || ekzFieldMin.getText().equals("") || ekzField2Min.getText().equals("")
                        || ekzFieldMax.getText().equals("") || ekzField2Max.getText().equals(""))){
                    List<String> exams = new ArrayList<>();
                    List<Integer> marks = new ArrayList<>();
                    exams.add(ekz2.getValue());
                    exams.add(ekz1.getValue());
                    marks.add(Integer.valueOf(ekzField2Min.getText()));
                    marks.add(Integer.valueOf(ekzField2Max.getText()));
                    marks.add(Integer.valueOf(ekzFieldMin.getText()));
                    marks.add(Integer.valueOf(ekzFieldMax.getText()));
                    Student stud = new Student("", Integer.valueOf(groupField.getText()), exams, marks);

                    List<Pair<Student, Integer>> list = controller.searchByGroup(stud);

                    controller.tableDataList.clear();

                    for(Pair<Student, Integer> p : list){
                        controller.tableDataList.add(p.getKey());
                    }

                    Stage stage = (Stage) save.getScene().getWindow();
                    stage.close();
                } else {
                    controller.showAlertSomeFieldsAreEmpty();
                }
            }
        });

        hBox1.getChildren().addAll(group, groupField, ekz1, min1, ekzFieldMin,  max1, ekzFieldMax);
        hBox1.setPadding(new Insets(15, 20, 20, 12));
        hBox1.setSpacing(10);
        hBox2.getChildren().addAll(ekz2, min2, ekzField2Min, max2, ekzField2Max, save);
        hBox2.setPadding(new Insets(15, 20, 20, 12));
        hBox2.setSpacing(10);

        vBox.getChildren().addAll(hBox1, hBox2);

        return vBox;
    }
}
