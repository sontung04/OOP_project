package BattleShip;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DifficultySelectionController implements Initializable {
    @FXML
    private AnchorPane rootPane;
    private List<Rectangle> rectangles = new ArrayList<>();
    private List<Button> buttons = new ArrayList<>();
    private List<Boolean> buttonsClicked = new ArrayList<>();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize buttons and rectangles
        for (int i = 1; i <= 5; i++) {
            Button button = (Button) rootPane.lookup("#button" + i);
            if (button != null) {
                buttons.add(button);
                buttonsClicked.add(false);  // Initialize buttonsClicked list
            }
        }
        for (int i = 1; i <= 5; i++) {
            Rectangle rectangle = (Rectangle) rootPane.lookup("#rectangle" + i);
            if (rectangle != null) {
                rectangles.add(rectangle);
            }
        }

        // Set button click and exit actions
        for (int i = 0; i < buttons.size(); i++) {
            final int index = i;
            Rectangle rectangle = rectangles.get(index);
            Button button = buttons.get(index);

            rectangle.setFill(Paint.valueOf("#00ff00"));
            rectangle.setVisible(false);

            button.setOnMouseClicked(mouseEvent -> {
                // Set the clicked button's rectangle to visible and mark it as clicked
                rectangle.setVisible(true);
                buttonsClicked.set(index, true);

                // Hide rectangles of other buttons in the same group
                if (index <= 2) {
                    for (int j = 0; j <= 2; j++) {
                        if (j != index) {
                            rectangles.get(j).setVisible(false);
                            buttonsClicked.set(j, false);
                        }
                    }
                } else {
                    for (int j = 3; j <= 4; j++) {
                        if (j != index) {
                            rectangles.get(j).setVisible(false);
                            buttonsClicked.set(j, false);
                        }
                    }
                }
            });

            button.setOnMouseExited(mouseEvent -> {
                // Hide the rectangle if the button is not clicked
                if (!buttonsClicked.get(index)) {
                    rectangle.setVisible(false);
                }
            });
        }
    }
    @FXML
    public void switchToMainScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BattleShipMainScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void switchToReadyScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReadyScreen.fxml"));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

