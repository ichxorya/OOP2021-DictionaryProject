module uet.oop.ourtreedictionary {
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

    opens uet.oop.ourtreedictionary to javafx.fxml;
    exports uet.oop.ourtreedictionary;

    //needed for HTTP
    requires unirest.java;
    requires jsapi;
    requires freetts;
}