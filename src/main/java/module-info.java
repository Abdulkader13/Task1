module com.example.decorator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.decorator to javafx.fxml;
    exports com.example.decorator;
}