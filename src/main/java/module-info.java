module com.example.javatasks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javatasks to javafx.fxml;
    exports com.example.javatasks;
}