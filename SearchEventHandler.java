package com.company;

import com.company.AddWindow;
import com.company.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SearchEventHandler implements EventHandler<ActionEvent> {
    private Controller controller;
    private Stage stage;

    public SearchEventHandler(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;
    }

    @Override
    public void handle(ActionEvent event) {
        new SearchWindow(stage, controller);
    }
}
