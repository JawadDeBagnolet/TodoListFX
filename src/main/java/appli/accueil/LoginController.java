package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public static Stage mainStage;
    public Button connexionButton;
    public Hyperlink inscriptionHyperlink;
    public Label mdpText;
    @FXML
    public TextField mdpField;
    public Label emailText;
    public Label connectedText;
    @FXML
    private TextField emailField;
    public Label erreurLabel;

    @FXML
    private Label welcomeText;

    @FXML
    void onConnexionButtonClick() {
        System.out.println("Email saisi : "+getEmailField().getText());
        System.out.println("Mot de Passe saisi : "+ getMdpField().getText());
        if (getEmailField().getText().equals("email") && getMdpField().getText().equals("Azerty1234")) {
            connectedText.setText("Vous voilà connecte !");
        }else {
            connectedText.setText("Email ou Mot de Passe saisi incorrect");
        }
    }
    void redirectionInscription() throws IOException {
        StartApplication.changeScene("Inscription");
    }
    @FXML
    public TextField getMdpField() {
        return mdpField;
    }

    @FXML
    public void setMdpField(TextField mdpField) {
        this.mdpField = mdpField;
    }

    @FXML
    public TextField getEmailField() {
        return emailField;
    }

    @FXML
    public void setEmailField(TextField emailField) {
        this.emailField = emailField;
    }
}