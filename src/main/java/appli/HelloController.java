package appli;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onRaphinhaButtonClick() {
        welcomeText.setText("RAPHINHA AURA SON BALLON D'OR");
    }
    @FXML
    protected void onSalahButtonClick() {
        welcomeText.setText("SALAH EST MOINS BON QUE RAPHINHAAAAA");
    }
}