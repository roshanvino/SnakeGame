package com.vino.snake.Controller;

import com.vino.snake.Model.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ApplicationController {

    @FXML
    private AnchorPane snake;

    @FXML
    void switchToSettings() throws IOException {
        new SceneSwitch(snake, "view/settings.fxml");
    }

    @FXML
    void switchToLeaderBoard() throws IOException {
        new SceneSwitch(snake, "view/leader-board.fxml");

    }

    @FXML
    void switchToStartGame() throws IOException {
        new SceneSwitch(snake, "view/start-game.fxml");
    }


}

