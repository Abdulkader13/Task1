module com.task6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.task6 to javafx.fxml;
    exports com.task6;
}