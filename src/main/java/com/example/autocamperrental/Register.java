package com.example.autocamperrental;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Register {

    @FXML
    private TextField Fname_txt;

    @FXML
    private TextField Lname_txt;

    @FXML
    private TextField email_txt;
    @FXML
    private TextField phone_txt;
    @FXML
    private TextField city_txt;

    @FXML
    private TextField DLicense_txt;

    @FXML
    private Button register_btn;
    @FXML
    private Label alert_lbl;
    @FXML
    private PasswordField password_txt;

    @FXML
    private PasswordField rePassword_txt;


    public Connection dataBaseLink;
    public PreparedStatement ps;
    public ResultSet rs;



    @FXML
    void registerNow() throws IOException {
        DBConnection DB=new DBConnection();
        DB.getConnection();
        String FirstName=Fname_txt.getText();
        String LastName =Lname_txt.getText();
        String DrivingLicense=DLicense_txt.getText();
        String city = city_txt.getText();
        String phoneNo=phone_txt.getText();
        String password =password_txt.getText();
        String re_password=rePassword_txt.getText();

        if (FirstName.isEmpty() || LastName.isEmpty()|| DrivingLicense.isEmpty() || city.isEmpty()|| password.isEmpty() ||re_password.isEmpty()) {
            alert_lbl.setText("Please Enter values inside the text field");
        } else {
            insertRegistration();
            insertLogin();
            alert_lbl.setText("Registeration is done");
            Stage stage=new Stage();
            FXMLLoader fxmlLoader6 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader6.load(), 800, 600);
            stage.setTitle("AutoCamperRentalApp!");
            stage.setScene(scene);
            stage.show();
        }
    }
    public void insertRegistration(){
        DBConnection DB=new DBConnection();
        dataBaseLink= DB.getConnection();
        String sqlInsert=("INSERT INTO register values (?,?,?,?,?,?,?,?)");
        try {
            ps=dataBaseLink.prepareStatement(sqlInsert);
            ps.setString(1,Fname_txt.getText());
            ps.setString(2,Lname_txt.getText());
            ps.setString(3,DLicense_txt.getText());
            ps.setString(4,city_txt.getText());
            ps.setString(5,phone_txt.getText());
            ps.setString(6,password_txt.getText());
            ps.setString(7,rePassword_txt.getText());
            ps.setString(8,email_txt.getText());

            ps.executeUpdate();
            ps.close();
            dataBaseLink.close();

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }

    }

    public void insertLogin(){
        DBConnection DB=new DBConnection();
        dataBaseLink= DB.getConnection();
        String sqlInsert=("INSERT INTO user_account values (?,?)");
        try {
            ps=dataBaseLink.prepareStatement(sqlInsert);
            ps.setString(1,email_txt.getText());
            ps.setString(2,password_txt.getText());

            ps.executeUpdate();
            ps.close();
            dataBaseLink.close();

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        }


    }

}
