package com.vino.snake.Controller;

import com.vino.snake.Model.GameMusic;
import com.vino.snake.Model.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MusicController {

    @FXML
    private AnchorPane music;
    @FXML
    void setMusicOne() {
        GameMusic.setMusicNum("src/main/resources/frogger.mp3");
    }

    @FXML
    void setMusicTwo() {
        GameMusic.setMusicNum("src/main/resources/duck.mp3");
    }

    @FXML
    void setMusicThree() {
        GameMusic.setMusicNum("src/main/resources/intense.mp3");

    }

    public void switchToSnakeView() throws IOException {
        new SceneSwitch(music, "view/snake.fxml");
    }
}
