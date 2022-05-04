package com.example.autocamperrental1;

import com.example.autocamperrental1.AutoCampers;

public class Luxury extends AutoCampers {
    double luxuryNormalPrice=120;
    int autoCamperNo1= getAutoCamper().get(0);
    int autoCamperNo2= getAutoCamper().get(1);
    int autoCamperNo3= getAutoCamper().get(2);
    int autoCamperNo4= getAutoCamper().get(3);

    public double getLuxuryNormalPrice() {
        return luxuryNormalPrice;
    }

    public void setLuxuryNormalPrice(double luxuryNormalPrice) {
        this.luxuryNormalPrice = luxuryNormalPrice;
    }

    public int getAutoCamperNo1() {
        return autoCamperNo1;
    }

    public void setAutoCamperNo1(int autoCamperNo1) {
        this.autoCamperNo1 = autoCamperNo1;
    }

    public int getAutoCamperNo2() {
        return autoCamperNo2;
    }

    public void setAutoCamperNo2(int autoCamperNo2) {
        this.autoCamperNo2 = autoCamperNo2;
    }

    public int getAutoCamperNo3() {
        return autoCamperNo3;
    }

    public void setAutoCamperNo3(int autoCamperNo3) {
        this.autoCamperNo3 = autoCamperNo3;
    }

    public int getAutoCamperNo4() {
        return autoCamperNo4;
    }

    public void setAutoCamperNo4(int autoCamperNo4) {
        this.autoCamperNo4 = autoCamperNo4;
    }
}
