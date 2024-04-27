package com.vino.snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * The main class for the application.
 * Extends the JavaFX Application class and initializes the game window.
 * starts the main menu for the application
 */
public class SnakeApplication extends Application {

    /**
     * The entry point for the application.
     *
     * @param stage The primary stage for the application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeApplication.class.getResource("view/snake.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 562.5);
        stage.setTitle("Snake Game");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main method, launching the FX application.
     *
     * @param args Command line arguments -  not used
     */
    public static void main(String[] args) {
        launch();
    }
}