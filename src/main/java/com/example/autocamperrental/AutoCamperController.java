package com.example.autocamperrental;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AutoCamperController {



    Stage stage=new Stage();
    @FXML
    void login() throws IOException {

        FXMLLoader fxmlLoader5 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader5.load(), 800, 600);
        stage.setTitle("AutoCamperRentalApp!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void register() throws IOException {

        FXMLLoader fxmlLoader6 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Register.fxml"));
        Scene scene = new Scene(fxmlLoader6.load(), 800, 600);
        stage.setTitle("AutoCamperRentalApp!");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void barChart() throws IOException {

        FXMLLoader fxmlLoader9 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("BarChart.fxml"));
        Scene scene = new Scene(fxmlLoader9.load(), 800, 600);
        stage.setTitle("AutoCamperRentalApp!");
        stage.setScene(scene);
        stage.show();
    }
}
