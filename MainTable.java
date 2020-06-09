package com.company;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainTable implements ComponentLinker{
    private Controller controller;
    private Stage stage;

    private HBox hBox;

    public MainTable(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;
    }

    @Override
    public void link() {
        hBox = new HBox();

        //TableView<Student> mainTable = controller.genTable();

        //mainTable.setItems(controller.tableDataList);

        hBox.getChildren().addAll(controller.genMainTable());
        hBox.setPadding(new Insets(15, 20, 20, 12));
        hBox.setSpacing(10);
    }

    @Override
    public HBox component() {
        return hBox;
    }
}
