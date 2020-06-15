package com.company;

        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.stage.Stage;

        import javax.xml.parsers.ParserConfigurationException;
        import javax.xml.transform.TransformerException;
        import java.io.File;

public class SaveHandler implements EventHandler<ActionEvent> {
    private Controller controller;
    private Stage stage;

    public SaveHandler(Stage mainStage, Controller mainController){
        this.stage = mainStage;
        this.controller = mainController;
    }

    @Override
    public void handle(ActionEvent event){
        File file = new File("C:\\Users\\User\\IdeaProjects\\PPvIS-2\\Students data.xml");
        try {
            controller.saveTableData(file);
        } catch (TransformerException | ParserConfigurationException e){
            e.printStackTrace();
        }
    }
}
