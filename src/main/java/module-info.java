module com.example.autocamperrental {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;


    opens com.example.autocamperrental to javafx.fxml;
    exports com.example.autocamperrental;
    exports com.example.autocamperrental1;
    opens com.example.autocamperrental1 to javafx.fxml;
}