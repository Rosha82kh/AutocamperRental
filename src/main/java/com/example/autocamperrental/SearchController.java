package com.example.autocamperrental;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    @FXML
    private TextField driving_txt;

    @FXML
    private TextField location_txt;

    @FXML
    private ComboBox<Integer> week_combo;

    @FXML
    private Button search_btn;

    @FXML
    private TextField insurance_txt;
    @FXML
    private Label alert_lbl;


    public Connection connection;
    public PreparedStatement ps;
    public ResultSet rs;


    public int getInsurance() {
        int price = 0;
        if (insurance_txt.getText().equalsIgnoreCase("full")) {
            price = 100;
        } else if (insurance_txt.getText().equalsIgnoreCase("basic")) {
            price = 50;
        }
        return price;
    }


    public boolean checkAvailability() throws SQLException {
        int weekNo = week_combo.getSelectionModel().getSelectedItem();
        Connection conn = null;
        DBConnection DB = new DBConnection();
        DB.getConnection();
        try {
            String sql = ("Select * from weeks where week_no=" + weekNo);
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery(sql);
            while (rs.next()) {
                if (rs.next() == true) {
                    alert_lbl.setText("This week not available try another week");
                } else {
                    searchStandard();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally {

            conn.close();
            return false;
        }
    }

    public void searchBasic() {

    }

    public void searchLuxury() {

    }

    public void searchStandard() throws IOException, SQLException {
        if (location_txt.getText() != null && driving_txt.getText() != null && insurance_txt.getText() != null) {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader5 = new FXMLLoader(AutoCamperRentalApplication.class.getResource("Luxury.fxml"));
            Scene scene = new Scene(fxmlLoader5.load(), 800, 600);
            stage.setTitle("AutoCamperRentalApp!");
            stage.setScene(scene);
            stage.show();
        }

    }


    protected void insertNewReservation() {
        int weekNo = week_combo.getSelectionModel().getSelectedItem();
        Connection conn = null;
        DBConnection DB = new DBConnection();
        DB.getConnection();
        try {
            String sql = ("Insert into reservation values ?,?,?,?,?");
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setInt(2, weekNo);
            pr.setInt(3, getAutoCamperNo());
            pr.setString(4, driving_txt.getText());
            pr.setString(5, insurance_txt.getText());
            pr.executeUpdate();


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }


    }

    private int getAutoCamperNo() {

        return 0;
    }

    public void cancelReservation() {


    }

    public void changeStatusWeek() {
        int weekNo = week_combo.getSelectionModel().getSelectedItem();
        Connection conn = null;
        DBConnection DB = new DBConnection();
        DB.getConnection();
        try {
            String sql = ("Insert into week values ? where week_no=weekNo");
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(2, "Booked");

            pr.executeUpdate();


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }


    }

    public ObservableList<Integer> getUNBookedWeek() throws SQLException {
        DBConnection DB = new DBConnection();
        connection=DB.getConnection();
        try {
            String sql = ("select * from weeks where status ='unbooked';");
            ps = connection.prepareStatement(sql);
            var rs = ps.executeQuery();

            var list = FXCollections.observableList(new ArrayList<Integer>());
            while (rs.next()) {
                var week_no = rs.getInt(1);
                list.add(week_no);
            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally {
            ps.close();
            connection.close();
        }
        return getUNBookedWeek();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Week w = new Week();

        // Unbooked weeks

        try {
            var list = getUNBookedWeek();

            if (list != null) {
                w.setWeekNo(list);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            week_combo.setItems(getUNBookedWeek());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // week_combo.setItems(w.weekNo);
    }
}

