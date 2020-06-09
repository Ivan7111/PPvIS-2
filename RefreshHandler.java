package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class RefreshHandler implements EventHandler<ActionEvent> {
    private Controller controller;
    private Stage stage;

    public RefreshHandler(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;
    }

    @Override
    public void handle(ActionEvent event) {
        controller.refreshTable();
    }
}
