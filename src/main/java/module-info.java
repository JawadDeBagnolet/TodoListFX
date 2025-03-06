module appli.todolistfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens appli to javafx.fxml;
    exports appli;
}