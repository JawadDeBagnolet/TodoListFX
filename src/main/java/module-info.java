module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens appli to javafx.fxml;
    exports appli;
    exports appli.accueil;
    opens appli.accueil to javafx.fxml;
}