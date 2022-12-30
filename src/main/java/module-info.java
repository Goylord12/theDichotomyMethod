module com.example.gg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;


    opens com.example.gg to javafx.fxml;
    exports com.example.gg;
}