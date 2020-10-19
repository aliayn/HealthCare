package com.ali.ayn.healthcare.db.bmiResult;

import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Table;

@Table(name = "BmiData")
public class BmiData extends SugarRecord {

    @Column(name = "time")
    long time = 0;
    @Column(name = "bmi")
    int bmi = 0;
    @Column(name = "isMale")
    boolean isMale = false;

    public BmiData() {
    }

    public BmiData(long time, int bmi, boolean isMale) {
        this.time = time;
        this.bmi = bmi;
        this.isMale = isMale;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getBmi() {
        return bmi;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
