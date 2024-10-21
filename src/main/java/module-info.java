module com.example.abstractclass {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;


    opens com.example.abstractclass to javafx.fxml;
    exports com.example.abstractclass;
}