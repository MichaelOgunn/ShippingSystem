module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;

    requires com.dlsc.formsfx;

    opens com.example.demo to javafx.fxml,xstream;
    exports com.example.demo;
    exports model to xstream, org.junit.jupiter.api;
    opens model to xstream, org.junit.jupiter.api;


}