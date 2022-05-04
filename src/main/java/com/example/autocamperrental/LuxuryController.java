package com.example.autocamperrental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LuxuryController extends SearchController {
    @FXML
    private Button luxuryBook1_btn;

    @FXML
    private Button luxuryBook2_btn;

    Stage stage = new Stage();


    public LuxuryController makeReservation() throws SQLException, IOException {
        if( getInsurance()!=0){
            insertNewReservation();
            changeStatusWeek();

            System.out.println("done");
            FXMLLoader fxmlLoader5 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Payment.fxml"));
            Scene scene = new Scene(fxmlLoader5.load(), 800, 600);
            stage.setTitle("AutoCamperRentalApp!");
            stage.setScene(scene);
            stage.show();
        }
        return null;
    }
}
