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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UtilisateurRepository;
import model.Utilisateur;

import java.io.IOException;

public class LoginController {
    private static Stage mainStage;
    @FXML
    private Button connexionButton;
    @FXML
    private Hyperlink inscriptionHyperlink;
    @FXML
    private Label mdpText;
    @FXML
    private TextField mdpField;
    @FXML
    private Label emailText;
    @FXML
    private Label connectedText;
    @FXML
    private TextField emailField;
    @FXML
    private Label erreurLabel;
    @FXML
    private Label welcomeText;


    @FXML
    void onConnexionButtonClick() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurParEmail(emailField.getText());
        if (utilisateur.getMdp().equals(passwordEncoder.encode(mdpField.getText()))) {
            connectedText.setText("Vous êtes connecté !");
            System.out.println(utilisateur.getNom());
            System.out.println(utilisateur.getPrenom());
            System.out.println(utilisateur.getRole());
            System.out.println(utilisateur.getEmail());
            connexionButton.setVisible(true);
        }else {
            connectedText.setText("Saisies invalides, réessayez ou inscrivez-vous.");
            connectedText.setVisible(true);
        }
        System.out.println("Email saisi : "+getEmailField().getText());
        System.out.println("Mot de Passe saisi : "+ getMdpField().getText());


    }
    @FXML
    void redirectionInscription() throws IOException {
        StartApplication.changeScene("accueil/Inscription");
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