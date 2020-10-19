package com.ali.ayn.healthcare.mapper;

import android.content.Context;
import com.ali.ayn.healthcare.R;
import com.ali.ayn.healthcare.db.bmiResult.BmiData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChartDataMapper {

    public static ArrayList<IBarDataSet> creator(List<BmiData> dataList, Context context) {
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        List<BarEntry> valueSet1 = new ArrayList<>();
        List<Integer> colors = new ArrayList<>();

        for (int i = 0; i < dataList.size(); i++) {
            BmiData bmiData = dataList.get(i);

            colors.add(getColor(bmiData.getBmi(), context));
            valueSet1.add(new BarEntry(bmiData.getBmi(), getMonth(bmiData.getTime())));

            BarDataSet barDataSet1 = new BarDataSet(valueSet1, "" + (i + 1));
            barDataSet1.setColors(colors);

            dataSets.add(barDataSet1);
            valueSet1.clear();
            colors.clear();
        }

        return dataSets;
    }

    private static int getMonth(long date) {
        Date date1 = new Date(date);
        return date1.getMonth();
    }

    private static int getColor(int bmi, Context context) {
        if (bmi < 20)
            return context.getResources().getColor(R.color.blue);

        else if (bmi < 25)
            return context.getResources().getColor(R.color.green);

        else if (bmi < 30)
            return context.getResources().getColor(R.color.yellow);

        else return context.getResources().getColor(R.color.red);
    }
}
