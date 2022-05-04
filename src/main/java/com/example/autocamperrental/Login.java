package com.example.autocamperrental;

import javafx.event.ActionEvent;
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

public class Login {

    @FXML
    private Button cancel_btn;

    @FXML
    private TextField email_txt;

    @FXML
    private PasswordField passowrd_txt;

    @FXML
    private Button login_btn;
    @FXML
    private Label lblMessege;

    public Connection connection;
    public PreparedStatement ps;
    public ResultSet rs;



    public void login(ActionEvent event) throws SQLException, IOException {
        validateLogin();
        if (email_txt.getText().isBlank()==false && passowrd_txt.getText().isBlank()==false){
            lblMessege.setText("You are login now");
            Stage stage=new Stage();
            FXMLLoader fxmlLoader5 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Search.fxml"));
            Scene scene = new Scene(fxmlLoader5.load(), 800, 600);
            stage.setTitle("AutoCamperRentalApp!");
            stage.setScene(scene);
            stage.show();

        }else {
            lblMessege.setText("please enter username and password");
        }}
    public void cancel(ActionEvent event){
        Stage stage=(Stage) cancel_btn.getScene().getWindow();
        stage.close();

    }
    public void validateLogin() throws SQLException {
        DBConnection DB=new DBConnection();
        connection=DB.getConnection();
        String verifyLogin ="SELECT * from user_account where Email=? and password =? ";

        try{
            ps=connection.prepareStatement(verifyLogin);
            ps.setString(1, email_txt.getText());
            ps.setString(2,passowrd_txt.getText());
            // EXECUTE THE  QRY
            rs=ps.executeQuery();
            while(rs.next()){
                if (rs.next()==true){
                    lblMessege.setText("You are login now !");
                }else {
                    lblMessege.setText("invalid Login");

                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }finally {
            rs.close();
            ps.close();
            connection.close();
        }
    }
}
