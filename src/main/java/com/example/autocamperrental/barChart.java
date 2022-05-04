package com.example.autocamperrental;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class barChart implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private CategoryAxis categoryX;

    @FXML
    private NumberAxis categoryY;


    //categoryX.

    public Connection connection;
    public PreparedStatement ps;
    public PreparedStatement ps2;
    public PreparedStatement ps3;
    public ResultSet rs1;
    ArrayList<Integer>discount1=new ArrayList<Integer>();


    public int Extra1;
    public int Extra2;
    public int Extra3;

    public  ArrayList<Integer> XYChart;

    public ArrayList<Integer> getAvg() throws SQLException {


    DBConnection DB=new DBConnection();
    connection=DB.getConnection();
    String sql="Select * from BarChart ";
    String sql1 ="select avg(Extrapaid) ExstraPaid from BarChart where DiscountCategories =1 AND  Extrapaid>0 ";
    String sql2 ="select avg(Extrapaid) ExstraPaid from BarChart where DiscountCategories =2 AND  Extrapaid>0 ";
    String sql3 ="select avg(Extrapaid) ExstraPaid from BarChart where DiscountCategories =3 AND  Extrapaid>0 ";


    try{
        ps=connection.prepareStatement(sql);

        // EXECUTE THE  QRY
         rs1=ps.executeQuery();


       while (rs1.next()){
           discount1.add(rs1.getInt(1));
           discount1.add(rs1.getInt(2));
           discount1.add(rs1.getInt(3));
        }




        CategoryAxis xAxis=new CategoryAxis();
        xAxis.setLabel("categories");
        NumberAxis yAxis=new NumberAxis();
        yAxis.setLabel("discount");
        XYChart.Series dataSeries=new XYChart.Series();
        dataSeries.setName("Customers discount");
        for(int i=0;i<discount1.size();i++){
            dataSeries.getData().add(discount1.get(i));
            barChart.getData().add(dataSeries);

        }}catch (Exception e){
        e.printStackTrace();
        e.getMessage();
    }finally {
        rs1.close();
        ps.close();
        connection.close();

            }

        return  discount1;
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().addAll(new ArrayList<>());


    }

}