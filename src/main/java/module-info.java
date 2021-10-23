module com.example.tree_dictionary_app {
    requires javafx.swing;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.tree_dictionary_app to javafx.fxml;
    exports com.example.tree_dictionary_app;

    //needed for HTTP
    requires unirest.java;

}