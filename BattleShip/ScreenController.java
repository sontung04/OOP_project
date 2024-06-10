package BattleShip;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScreenController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize screen-specific logic here
    }

    public void switchToDifficultySelectionScreen(ActionEvent event) throws IOException {
            root = FXMLLoader.load(getClass().getResource("DifficultySelectionScreen.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    public void switchToMainScreen(ActionEvent event) throws  IOException {
        root = FXMLLoader.load(getClass().getResource("BattleShipMainScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToReadyScreen(ActionEvent event) throws  IOException {
        root = FXMLLoader.load(getClass().getResource("ReadyScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToGameScreen(ActionEvent event) throws  IOException {
        root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
