module co.uniquindio.cinecolas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens co.uniquindio.cinecolas to javafx.fxml;
    exports co.uniquindio.cinecolas;
}