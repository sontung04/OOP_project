package BattleShip;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;

public class GameScreenController implements Initializable {
    @FXML
    private AnchorPane rootPane; // Gốc của giao diện FXML
    private List<Rectangle> shoots = new ArrayList<>();
    private List<Button> buttons = new ArrayList<>();
    private List<Boolean> buttonsClicked = new ArrayList<>();

    Image shootImage = new Image(getClass().getResource("/BattleShip/Image/Shoot.png").toExternalForm());
    ImagePattern imageshoot = new ImagePattern(shootImage);
    Image hitImage = new Image(getClass().getResource("/BattleShip/Image/Miss.png").toExternalForm());
    ImagePattern imagehit = new ImagePattern(hitImage);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Khởi tạo và thêm 100 trạng thái của các nút vào danh sách
        for (int i = 1; i <= 100; i++) {
            buttonsClicked.add(false); // Khởi tạo trạng thái của nút là chưa được nhấn
        }

        // Tìm và thêm 100 đối tượng Button vào danh sách
        for (int i = 1; i <= 100; i++) {
            Button button = (Button) rootPane.lookup("#button" + i);
            if (button != null) {
                buttons.add(button);
            }
        }

        // Tìm và thêm 100 đối tượng Rectangle vào danh sách
        for (int i = 1; i <= 100; i++) {
            Rectangle shoot = (Rectangle) rootPane.lookup("#shoot" + i);
            if (shoot != null) {
                shoots.add(shoot);
            }
        }

        // Thiết lập sự kiện cho từng đối tượng
        for (int i = 0; i < buttons.size(); i++) {
            final int index = i; // Biến final để sử dụng trong lambda
            Rectangle shoot = shoots.get(index);
            Button button = buttons.get(index);

            shoot.setFill(imageshoot);
            shoot.setVisible(false);

            button.setOnMouseClicked(mouseEvent -> {
                shoot.setFill(imagehit);
                buttonsClicked.set(index, true);  // Đánh dấu nút đã được nhấn
                button.setVisible(false);  // Ẩn nút sau khi bấm
                button.setManaged(false);  // Loại bỏ nút khỏi layout
            });

            button.setOnMouseEntered(mouseEvent -> {
                if (!buttonsClicked.get(index)) {  // Chỉ hiển thị nếu nút chưa được nhấn
                    shoot.setVisible(true);
                }
            });

            button.setOnMouseExited(mouseEvent -> {
                if (!buttonsClicked.get(index)) {  // Chỉ ẩn nếu nút chưa được nhấn
                    shoot.setVisible(false);
                }
            });
        }
    }
}

