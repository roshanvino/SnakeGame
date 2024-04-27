package com.vino.snake.Controller;

import com.vino.snake.Model.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LeaderBoardController {

    @FXML
    private AnchorPane leaderBoard;


    @FXML
    void switchToSnakeView() throws IOException {
        new SceneSwitch(leaderBoard, "view/snake.fxml");
    }

}