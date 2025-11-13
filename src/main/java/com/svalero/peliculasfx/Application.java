package com.svalero.peliculasfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("peliculasfx.fxml"));
        fxmlLoader.setController(new ApplicationController());
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("PeliculasFx");
        stage.setScene(scene);
        stage.show();
    }
}
