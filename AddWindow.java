package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AddWindow {
    private Controller controller;
    private Stage stage;

    public AddWindow(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;

        VBox vBox = getAddLayout();

        Scene scene = new Scene(vBox);
        Stage newStage = new Stage();
        newStage.setTitle("Adding");
        newStage.initOwner(stage);
        newStage.setScene(scene);
        newStage.showAndWait();
    }

    public VBox getAddLayout(){
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

        Label name = new Label("Name");
        TextField nameField = new TextField();
        Label group = new Label("Group");
        TextField groupField = new TextField();

        ComboBox<String> ekz1 = new ComboBox<>();
        ekz1.getItems().addAll(exams);
        TextField ekzField1 = new TextField();

        ComboBox<String> ekz2 = new ComboBox<>();
        ekz2.getItems().addAll(exams);
        TextField ekzField2 = new TextField();

        ComboBox<String> ekz3 = new ComboBox<>();
        ekz3.getItems().addAll(exams);
        TextField ekzField3 = new TextField();

        ComboBox<String> ekz4 = new ComboBox<>();
        ekz4.getItems().addAll(exams);
        TextField ekzField4 = new TextField();

        ComboBox<String> ekz5 = new ComboBox<>();
        ekz5.getItems().addAll(exams);
        TextField ekzField5 = new TextField();

        Button save = new Button("Save");
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!(nameField.getText().equals("") || groupField.getText().equals("") || ekzField1.getText().equals("") ||
                        ekzField2.getText().equals("") || ekzField3.getText().equals("") || ekzField4.getText().equals("") ||
                        ekzField5.getText().equals(""))){
                    List<String> exams = new ArrayList<>();
                    List<Integer> marks = new ArrayList<>();
                    exams.add(ekz1.getValue());
                    marks.add(Integer.valueOf(ekzField1.getText()));
                    exams.add(ekz2.getValue());
                    marks.add(Integer.valueOf(ekzField2.getText()));
                    exams.add(ekz3.getValue());
                    marks.add(Integer.valueOf(ekzField3.getText()));
                    exams.add(ekz4.getValue());
                    marks.add(Integer.valueOf(ekzField4.getText()));
                    exams.add(ekz5.getValue());
                    marks.add(Integer.valueOf(ekzField5.getText()));
                    Student stud = new Student(nameField.getText(), Integer.valueOf(groupField.getText()), exams, marks);

                    controller.tableDataList.add(stud);
                    controller.allDataList.add(stud);

                    Stage stage = (Stage) save.getScene().getWindow();
                    stage.close();
                } else {
                    controller.showAlertSomeFieldsAreEmpty();
                }
            }
        });

        hBox1.getChildren().addAll(name, nameField, group, groupField, ekz1, ekzField1, ekz2, ekzField2);
        hBox1.setPadding(new Insets(15, 20, 20, 12));
        hBox1.setSpacing(10);
        hBox2.getChildren().addAll(ekz3, ekzField3, ekz4, ekzField4, ekz5, ekzField5, save);
        hBox2.setPadding(new Insets(15, 20, 20, 12));
        hBox2.setSpacing(10);

        vBox.getChildren().addAll(hBox1, hBox2);

        return vBox;
    }
}
