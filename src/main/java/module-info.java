module com.vino.snake {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jlayer;


    opens com.vino.snake to javafx.fxml;
    exports com.vino.snake;
    exports com.vino.snake.Controller;
    opens com.vino.snake.Controller to javafx.fxml;
    exports com.vino.snake.Model;
    opens com.vino.snake.Model to javafx.fxml;
}