package com.company;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class TableControls implements ComponentLinker{
    private Controller controller;
    private Stage stage;

    private HBox hBox;

    public TableControls(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;
    }

    @Override
    public void link() {
        hBox = new HBox();

        Button add = new Button("Add");
        add.setOnAction(new AddEventHandler(stage, controller));
        Button search = new Button("Search");
        search.setOnAction(new SearchEventHandler(stage, controller));
        Button delete = new Button("Delete");
        delete.setOnAction(new DeleteEventHandler(stage, controller));
        Button save = new Button("Save");
        save.setOnAction(new SaveHandler(stage, controller));
        Button load = new Button("Load");
        load.setOnAction(new LoadHandler(stage, controller));

        hBox.getChildren().addAll(add, search, delete, save, load);
        hBox.setPadding(new Insets(15, 20, 20, 12));
        hBox.setSpacing(10);
    }

    @Override
    public HBox component() {
        return hBox;
    }
}
