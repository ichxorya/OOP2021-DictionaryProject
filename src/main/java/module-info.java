module com.example.tree_dictionary_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires voicerss.tts;
    requires java.datatransfer;
    requires java.desktop;
    requires javafx.media;

    opens com.example.tree_dictionary_app to javafx.fxml;
    exports com.example.tree_dictionary_app;
}