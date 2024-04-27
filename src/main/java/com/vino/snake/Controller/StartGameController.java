package com.vino.snake.Controller;

import com.vino.snake.Model.GameMusic;
import com.vino.snake.Model.SceneSwitch;
import com.vino.snake.original.MusicPlayer;
import com.vino.snake.original.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static com.vino.snake.Model.GameMusic.getMusicNum;

public class StartGameController {

    @FXML
    private TextField inputName;

    @FXML
    private AnchorPane startGame;

    @FXML
    void onEnterClick(ActionEvent event) {
        Play game = new Play();
        game.loadFrame();
        String music = getMusicNum();
        MusicPlayer.getMusicPlay(music);

    }

    @FXML
    void switchToSnakeView() throws IOException {
        new SceneSwitch(startGame, "view/snake.fxml");
    }


    public String getUsername() {
        return inputName.getText();
    }

}
