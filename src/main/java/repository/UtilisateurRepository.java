package repository;
import database.Database;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurRepository {
    private Connection cnx;

    public UtilisateurRepository() {
        this.cnx = Database.getConnexion();
    }
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mot_de_passe) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        return false;
    }
    public Utilisateur getUtilisateurParEmail(String email) {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        try {
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Utilisateur user = new Utilisateur(
                        rs.getInt("id_utilisateur"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        rs.getString("role")
                );
                return user;
            }
        }
        catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return null;
    }
    public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        String sql = "SELECT * FROM utilisateur";
        try{
            PreparedStatement stmt = this.cnx.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur(
                rs.getInt("id_utilisateur"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("email"),
                rs.getString("mot_de_passe"),
                rs.getString("role")
                );

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        return null;
    }

    public void supprimerUtilisateurParEmail(String email) throws SQLException {
        String sql = "DELETE FROM utilisateur WHERE email = ?";
        try {
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public void mettreAJourUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateur SET nom = ? , prenom = ?, mdp = ?, role = ? WHERE email = ?";
        try {
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }


}
