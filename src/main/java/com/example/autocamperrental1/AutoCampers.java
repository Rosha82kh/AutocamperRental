package com.example.autocamperrental1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AutoCampers {

    double price;
     ObservableList<Integer> autoCamperNo= FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11);

    public ObservableList<Integer> getAutoCamper() {
        return autoCamperNo;
    }

    public void setAutoCamper(ObservableList<Integer> autoCamper) {
        this.autoCamperNo = autoCamper;
    }
}
