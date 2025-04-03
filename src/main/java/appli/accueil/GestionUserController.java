package appli.accueil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GestionUserController implements Initializable {
    @FXML
    private TableView<Utilisateur> tableauUser;
    @FXML
    private Button buttonDeconnexion;

    private Utilisateur utilisateurSelected = null;
    UtilisateurRepository userRepo = new UtilisateurRepository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"Id utilisateur","idUser"},
                {"Nom","nom"},
                {"Prénom","prenom"},
                {"Email","email"},
                {"Rôle","role"},
        };
        for(int i=0;i<colonnes.length;i++ ){
            TableColumn<Utilisateur,String> maCol = new TableColumn<>(colonnes[i][0]);
            //Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(
                    new PropertyValueFactory<Utilisateur,String>(colonnes[i][1])
            );
            //Ajout de la colonne dans notre tableau
            tableauUser.getColumns().add(maCol);
        }
        ArrayList<Utilisateur> infoUsers = userRepo.getTousLesUtilisateurs();
        tableauUser.getItems().addAll(infoUsers);
    }
    void onButtonSupprClick(ActionEvent actionEvent) throws SQLException {
        Utilisateur utilisateurSelected = tableauUser.getSelectionModel().getSelectedItem();
        UtilisateurRepository userRepo = new UtilisateurRepository();
        UtilisateurRepository.supprimerUtilisateurParEmail(utilisateurSelected.getEmail());
    }

    void redirectionDeconnexion() throws IOException {
        LoginController.handleLogout();
    }

    public javafx.scene.control.TableView<Utilisateur> getTableauUser() {
        return tableauUser;
    }

    public void setTableauUser(javafx.scene.control.TableView<Utilisateur> tableauUser) {
        this.tableauUser = tableauUser;
    }

    public Button getButtonDeconnexion() {
        return buttonDeconnexion;
    }

    public void setButtonDeconnexion(Button buttonDeconnexion) {
        this.buttonDeconnexion = buttonDeconnexion;
    }
}
