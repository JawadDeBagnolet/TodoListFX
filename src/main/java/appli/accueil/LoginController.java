package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UtilisateurRepository;
import model.Utilisateur;
import session.SessionUtilisateur;

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
        System.out.println("Email saisi : "+getEmailField().getText());
        System.out.println("Mot de Passe saisi : "+ getMdpField().getText());

        if (utilisateur!= null && passwordEncoder.matches(getMdpField().getText(), utilisateur.getMdp())) {
            System.out.println(utilisateur.getNom());
            System.out.println(utilisateur.getPrenom());
            System.out.println(utilisateur.getRole());
            System.out.println(utilisateur.getEmail());

            System.out.println("Connexion avec succes de l'utilisateur : "+utilisateur.getNom());
            SessionUtilisateur.getInstance().sauvegardeSession(utilisateur);
            connectedText.setVisible(false);
            connexionButton.setVisible(true);
            // redirection vers la page suivante
        } else{
            System.out.println("Echec de la connexion.");
            connectedText.setText("Echec de la connexion.");
            connectedText.setVisible(true);
            connexionButton.setVisible(true);
        }
        Utilisateur utilisateurActuel = SessionUtilisateur.getInstance().getUtilisateurConnecte();
        if (utilisateurActuel != null) {
            System.out.println("Utilisateur connecté : "+utilisateurActuel.getNom());
        }
    }
    @FXML
    protected void handleLogout(){
        SessionUtilisateur.getInstance().deconnecter();
        System.out.println("Utilisateur déconnecté.");
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