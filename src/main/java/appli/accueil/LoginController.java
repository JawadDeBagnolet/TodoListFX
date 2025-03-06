package appli.accueil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    public Button connexionButton;
    public Hyperlink inscriptionHyperlink;
    public Label mdpText;
    public TextField mdpField;
    public Label emailText;
    public TextField emailField;
    public Label erreurLabel;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onConnexionButtonClick() {
        welcomeText.setText("CONNECTE(E) !");
    }
}