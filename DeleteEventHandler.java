package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class DeleteEventHandler implements EventHandler<ActionEvent> {
    private Controller controller;
    private Stage stage;

    public DeleteEventHandler(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;
    }

    @Override
    public void handle(ActionEvent event) {
        new DeleteWindow(stage, controller);
    }
}
