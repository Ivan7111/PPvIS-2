package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class LoadHandler implements EventHandler<ActionEvent> {
    private Controller controller;
    private Stage stage;
    private SAXParser parser;

    public LoadHandler(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;
    }

    @Override
    public void handle(ActionEvent event){
        File file = new File("C:\\Users\\User\\IdeaProjects\\PPvIS-2\\Students data.xml");
        try {
            controller.getTableDataFromFile(file, parser);
        } catch (ParserConfigurationException | SAXException | IOException e){
            e.printStackTrace();
        }
        controller.refreshTable();
    }
}
