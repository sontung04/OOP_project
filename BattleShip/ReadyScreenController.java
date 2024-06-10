package BattleShip;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReadyScreenController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private AnchorPane rootPane; // Gốc của giao diện FXML

    @FXML
    private GridPane gridPane;

    private List<Rectangle> ships = new ArrayList<>();
    private List<Button> buttons = new ArrayList<>();
    private List<Boolean> buttonsClicked = new ArrayList<>();
    private boolean horizontal = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize buttons' states
        for (int i = 1; i <= 5; i++) {
            buttonsClicked.add(false);
        }

        // Find and add buttons to the list
        for (int i = 1; i <= 5; i++) {
            Button button = (Button) rootPane.lookup("#button" + i);
            if (button != null) {
                buttons.add(button);
            }
        }

        // Find and add ships to the list
        for (int i = 1; i <= 5; i++) {
            Rectangle ship = (Rectangle) rootPane.lookup("#ship" + i);
            if (ship != null) {
                ships.add(ship);
                setupDragAndDrop(ship); // Thiết lập sự kiện kéo và thả cho hình chữ nhật ngay khi khởi tạo
            }
        }

        // Set up events for buttons and ships
        for (int i = 0; i < buttons.size(); i++) {
            final int index = i; // Biến final để sử dụng trong lambda
            Rectangle ship = ships.get(index);
            Button button = buttons.get(index);
            ship.setVisible(false);

            button.setOnMouseClicked(mouseEvent -> {
                ship.setVisible(true);
                buttonsClicked.set(index, true);  // Đánh dấu nút đã được nhấn
            });

            button.setOnMouseExited(mouseEvent -> {
                if (!buttonsClicked.get(index)) {  // Chỉ ẩn nếu nút chưa được nhấn
                    ship.setVisible(false);
                }
            });
        }
    }

    private void setupDragAndDrop(Rectangle rectangle) {
        final Rotate rotate = new Rotate();
        rectangle.getTransforms().add(rotate);

        // Thiết lập sự kiện kéo và thả cho hình chữ nhật
        rectangle.setOnDragDetected(event -> {
            Dragboard db = rectangle.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(""); // Chúng ta không cần đặt bất kỳ nội dung nào
            db.setContent(content);
            event.consume();
        });

        // Thiết lập sự kiện kéo và thả cho GridPane
        gridPane.setOnDragOver(event -> {
            if (event.getGestureSource() != gridPane && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        gridPane.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                // Tính toán vị trí mới dựa trên vị trí của con trỏ chuột
                int newCol = Math.min(10, (int) event.getX() / 75);
                int newRow = Math.min(10, (int) event.getY() / 75);

                // Kiểm tra xem vị trí mới có nằm trong khu vực 10x10 ở góc dưới cùng bên phải hay không
                if (newCol >= 1 && newRow >= 1) {
                    // Di chuyển hình chữ nhật đến vị trí mới
                    GridPane.setColumnIndex((Node) event.getGestureSource(), newCol);
                    GridPane.setRowIndex((Node) event.getGestureSource(), newRow);
                    success = true;
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });

        // Thiết lập sự kiện nhấp chuột cho hình chữ nhật để xoay nó 90 độ
        rectangle.setOnMouseClicked(event -> {
            if (horizontal) {
                rotate.setPivotX(37.5);
                rotate.setPivotY(37.5);
                rotate.setAngle(90);
                horizontal = false;
            } else {
                rotate.setPivotX(37.5);
                rotate.setPivotY(37.5);
                rotate.setAngle(0);
                horizontal = true;
            }
        });
    }

    public void switchToGameScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
