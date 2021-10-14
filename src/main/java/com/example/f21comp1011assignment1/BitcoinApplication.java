package com.example.f21comp1011assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class BitcoinApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BitcoinApplication.class.getResource("bitcoin_table_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bitcoin");
        //set up the icon
        stage.getIcons().add(new Image("file:./bitcoin-icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}