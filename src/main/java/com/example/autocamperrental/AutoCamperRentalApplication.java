package com.example.autocamperrental;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AutoCamperRentalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(AutoCamperRentalApplication.class.getResource("AutoCampers.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Search.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Register.fxml"));
        FXMLLoader fxmlLoader4 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Login.fxml"));
        FXMLLoader fxmlLoader5 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Luxury.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 850, 650);
        stage.setTitle("AutoCamperRentalApp!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}