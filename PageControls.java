package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class PageControls implements ComponentLinker {
    private Controller controller;
    private Stage stage;
    private Label num;
    private ComboBox<Integer> numBox;

    private HBox hBox;

    public PageControls(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;
    }

    public int getPageNumber(){
        return Integer.valueOf(num.getText());
    }

    public void setPageNumber(int n){
        num.setText(Integer.toString(n));
    }

    public int getPageCount(){
        return numBox.getValue();
    }

    @Override
    public void link() {
        hBox = new HBox();

        Button first = new Button("<<");
        first.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.firstPage();
            }
        });
        Button prev = new Button("<");
        prev.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.pageDown();
            }
        });
        Button next = new Button(">");
        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.pageUp();
            }
        });
        Button last = new Button(">>");
        last.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.lastPage();
            }
        });
        num = new Label("1");
        Label select = new Label("Records per page");
        numBox = new ComboBox<>();
        numBox.getItems().addAll(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        numBox.setValue(10);
        Button refresh = new Button("Refresh table");
        refresh.setOnAction(new RefreshHandler(stage, controller));

        hBox.getChildren().addAll(first, prev, num, next, last, select, numBox, refresh);
        hBox.setPadding(new Insets(15, 20, 20, 12));
        hBox.setSpacing(10);
    }

    @Override
    public HBox component() {
        return hBox;
    }
}
