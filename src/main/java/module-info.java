module com.example.keeper {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.keeper to javafx.fxml;
    exports com.example.keeper;
}