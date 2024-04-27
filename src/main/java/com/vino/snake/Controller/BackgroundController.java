package com.vino.snake.Controller;

import com.vino.snake.Model.GameBackground;
import com.vino.snake.Model.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BackgroundController {

    @FXML
    private AnchorPane background;

    public void switchToSnakeView(ActionEvent event) throws IOException {
        new SceneSwitch(background, "view/snake.fxml");
    }

    @FXML
    void setBackgroundOne() {
        GameBackground.setBackgroundNum("UI-background");
    }

    @FXML
    void setBackgroundTwo() {
        GameBackground.setBackgroundNum("UI-background-2");
    }

    @FXML
    void setBackgroundThree() {
        GameBackground.setBackgroundNum("UI-background-3");

    }

}
