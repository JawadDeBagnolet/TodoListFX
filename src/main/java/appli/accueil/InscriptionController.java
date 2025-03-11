package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InscriptionController {
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
    private Label welcomeText;

    @FXML
    void redirectionInscription(ActionEvent event) {
        System.out.println("Nom :  " + nomField.getText());
        System.out.println("Prenom :  " + prenomField.getText());
        System.out.println("Email :  " + emailField.getText());
        System.out.println("Mot de Passe :  " + mdpField.getText());
        connectedText.setText("Vous voilà Inscrit !");
    }

    public TextField getPrenomField() {
        return prenomField;
    }

    public void setPrenomField(TextField prenomField) {
        this.prenomField = prenomField;
    }

    public TextField getNomField() {
        return nomField;
    }

    public void setNomField(TextField nomField) {
        this.nomField = nomField;
    }

    public TextField getMdpField() {
        return mdpField;
    }

    public void setMdpField(TextField mdpField) {
        this.mdpField = mdpField;
    }

    public TextField getConfirmationMdpField() {
        return confirmationMdpField;
    }

    public void setConfirmationMdpField(TextField confirmationMdpField) {
        this.confirmationMdpField = confirmationMdpField;
    }

    public TextField getEmailField() {
        return emailField;
    }

    public void setEmailField(TextField emailField) {
        this.emailField = emailField;
    }
}
