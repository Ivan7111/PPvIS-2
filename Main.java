package com.company;

import java.util.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage){
        VBox root = new VBox();

        Controller mainController = new Controller(stage);

        List<ComponentLinker> linkers = new ArrayList<>();
        linkers.add(new TableControls(stage, mainController));
        linkers.add(new MainTable(stage, mainController));
        PageControls pageControls = new PageControls(stage, mainController);
        linkers.add(pageControls);

        mainController.setPageControls(pageControls);

        List<HBox> groups = new ArrayList<>();
        for (ComponentLinker linker : linkers) {
            linker.link();
            groups.add(linker.component());
        }
        root.getChildren().addAll(groups);


        Scene scene = new Scene(root, 1000, 610);
        stage.setTitle("PPvIS-2");
        stage.setScene(scene);
        stage.show();

    }
}
