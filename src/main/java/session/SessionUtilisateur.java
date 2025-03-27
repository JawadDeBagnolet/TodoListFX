package session;

import model.Utilisateur;

public class SessionUtilisateur {
    private static SessionUtilisateur instance;
    private Utilisateur utilisateurConnecte;
    private SessionUtilisateur() {}
    public static SessionUtilisateur getInstance() {
        if (instance == null) {
            instance = new SessionUtilisateur();
        }
        return instance;
    }
    public void sauvegardeSession(Utilisateur utilisateur) {
        if (utilisateurConnecte == null) {
            utilisateurConnecte = utilisateur;
        }
    }
    public Utilisateur getUtilisateurConnecte() {
        return utilisateurConnecte;
    }
    public void deconnecter(){
        utilisateurConnecte = null;
    }
}
