package com.vino.snake.Controller;


import com.vino.snake.Model.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SettingsController {

    @FXML
    private AnchorPane settings;

    @FXML
    void switchToBackground() throws IOException {
        new SceneSwitch(settings, "view/background.fxml");

    }
    @FXML
    void switchToSnakeView() throws IOException {
        new SceneSwitch(settings, "view/snake.fxml");

    }

    @FXML
    void switchToMusic() throws IOException {
        new SceneSwitch(settings, "view/music.fxml");
    }

}
