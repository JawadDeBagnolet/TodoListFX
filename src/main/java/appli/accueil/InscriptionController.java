package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repository.UtilisateurRepository;
import model.Utilisateur;

import java.io.IOException;

public class InscriptionController {
    @FXML
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
    @FXML
    private TextField confirmationMdpField;
    @FXML
    private Label connectedText;
    @FXML
    private TextField emailField;
    @FXML
    private Button inscriptionButton;
    @FXML
    private TextField mdpField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField roleField;
    @FXML
    private Label welcomeText;

    @FXML
    void redirectionInscription(ActionEvent event) throws IOException {
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Utilisateur utilisateur = new Utilisateur(nomField.getText(), prenomField.getText(),emailField.getText(), passwordEncoder.encode(confirmationMdpField.getText()), "utilisateur");

        /*Utilisateur utilisateur = new utilisateurRepository.getUtilisateurParEmail(emailField.getText());*/

        System.out.println("Nom :  " + nomField.getText());
        System.out.println("Prenom :  " + prenomField.getText());
        System.out.println("Email :  " + emailField.getText());
        System.out.println("Mot de Passe :  " + mdpField.getText());
        System.out.println("Role :  " + roleField.getText());

        if (confirmationMdpField.getText().isEmpty()||nomField.getText().isEmpty()||prenomField.getText().isEmpty() || emailField.getText().isEmpty() || mdpField.getText().isEmpty()){
            connectedText.setText("Erreur : Champ(s) vide(s) !");
        }else if (!(confirmationMdpField.getText().equals(mdpField.getText()))) {
            connectedText.setText("Erreur : Les deux mot de passe sont différents !");
        }/*else if (emailField.getText().equals(utilisateur.getEmail())){
            connectedText.setText("Erreur : Email déjà utilisé !");
        }*/

        else {
            passwordEncoder.encode(mdpField.getText());
            Utilisateur user = new Utilisateur(nomField.getText(),prenomField.getText(),emailField.getText(),mdpField.getText(),"utilisateur");
            boolean estInstcrit = utilisateurRepository.ajouterUtilisateur(user);
            if (estInstcrit) {
                System.out.println("Inscription réussi !");
                StartApplication.changeScene("accueil/Login");
            }else {
                System.out.println("Erreur lors de l'inscription");
            }
        }
    }

    @FXML
    void redirectionConnexion() throws IOException {
        StartApplication.changeScene("accueil/Login");
    }
    @FXML
    public TextField getPrenomField() {
        return prenomField;
    }

    @FXML
    public void setPrenomField(TextField prenomField) {
        this.prenomField = prenomField;
    }

    @FXML
    public TextField getNomField() {
        return nomField;
    }

    @FXML
    public void setNomField(TextField nomField) {
        this.nomField = nomField;
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
    public TextField getConfirmationMdpField() {
        return confirmationMdpField;
    }

    @FXML
    public void setConfirmationMdpField(TextField confirmationMdpField) {
        this.confirmationMdpField = confirmationMdpField;
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
