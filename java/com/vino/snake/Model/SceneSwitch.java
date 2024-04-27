package com.vino.snake.Model;

import com.vino.snake.SnakeApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {

    /**
     * Constructs a SceneSwitch object to switch scenes.
     *
     * @param currentAnchorPane The current AnchorPane that needs to be updated
     * @param fxml  The FXML file path for the new scene
     * @throws IOException If an error occurs during the loading of the FXML file.
     */
    public SceneSwitch(AnchorPane currentAnchorPane, String fxml) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(SnakeApplication.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }
}
// handles the switch scene operation, is used to change between fxml screens (used in the controllers)