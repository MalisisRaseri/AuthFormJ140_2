module com.example.authformj140_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.authformj140_2 to javafx.fxml, javafx.base;
    opens Looks to javafx.base;
    exports com.example.authformj140_2;
    exports Looks;
}