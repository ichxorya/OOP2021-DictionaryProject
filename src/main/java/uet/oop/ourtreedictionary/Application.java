package uet.oop.ourtreedictionary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("dictGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dictionary!");
        stage.setScene(scene);
        stage.getIcons().add(appIcon());

        stage.show();

    }

    private Image appIcon() {
        return new Image(
                            Objects.requireNonNull(
                                Application.class.getResourceAsStream("deathnote_icon.png")
                         )
                    );
    }

    public static void main(String[] args) {
        launch();
    }
}