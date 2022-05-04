package com.example.autocamperrental1;

import com.example.autocamperrental1.AutoCampers;

public class Basic extends AutoCampers {
    double BasicDiscount;
    int autoCamperNo9= getAutoCamper().get(8);
    int autoCamperNo10= getAutoCamper().get(9);
    int autoCamperNo11= getAutoCamper().get(10);
    int autoCamperNo12= getAutoCamper().get(11);

    public int getAutoCamperNo9() {
        return autoCamperNo9;
    }

    public void setAutoCamperNo9(int autoCamperNo9) {
        this.autoCamperNo9 = autoCamperNo9;
    }

    public int getAutoCamperNo10() {
        return autoCamperNo10;
    }

    public void setAutoCamperNo10(int autoCamperNo10) {
        this.autoCamperNo10 = autoCamperNo10;
    }

    public int getAutoCamperNo11() {
        return autoCamperNo11;
    }

    public void setAutoCamperNo11(int autoCamperNo11) {
        this.autoCamperNo11 = autoCamperNo11;
    }

    public int getAutoCamperNo12() {
        return autoCamperNo12;
    }

    public void setAutoCamperNo12(int autoCamperNo12) {
        this.autoCamperNo12 = autoCamperNo12;
    }
}
