package in.mahabhujal.mahabhujal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarGraphActivity extends AppCompatActivity {
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        BarChart chart = findViewById(R.id.barchart);

        /*
        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(945f, 0));
        NoOfEmp.add(new BarEntry(1040f, 1));
        NoOfEmp.add(new BarEntry(1133f, 2));
        NoOfEmp.add(new BarEntry(1240f, 3));
        NoOfEmp.add(new BarEntry(1369f, 4));
        NoOfEmp.add(new BarEntry(1487f, 5));
        NoOfEmp.add(new BarEntry(1501f, 6));
        NoOfEmp.add(new BarEntry(1645f, 7));
        NoOfEmp.add(new BarEntry(1578f, 8));
        NoOfEmp.add(new BarEntry(1695f, 9));

        ArrayList year = new ArrayList();

        year.add("2008");
        year.add("2009");
        year.add("2010");
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "No Of Employee");
        chart.animateY(5000);
        BarData data = new BarData(bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
        */

        ArrayList<BarEntry> Rainfall = new ArrayList<>();

        Rainfall.add(new BarEntry(7f, 0));
        Rainfall.add(new BarEntry(2f, 1));
        Rainfall.add(new BarEntry(4f, 2));
        Rainfall.add(new BarEntry(2f, 3));
        Rainfall.add(new BarEntry(10f, 4));
        Rainfall.add(new BarEntry(296f, 5));
        Rainfall.add(new BarEntry(338f, 6));
        Rainfall.add(new BarEntry(288f, 7));
        Rainfall.add(new BarEntry(793f, 8));
        Rainfall.add(new BarEntry(402f, 9));
        Rainfall.add(new BarEntry(7f, 10));
        Rainfall.add(new BarEntry(0f, 11));

        ArrayList<String> month = new ArrayList<>();

        month.add("January");
        month.add("February");
        month.add("March");
        month.add("April");
        month.add("May");
        month.add("June");
        month.add("July");
        month.add("August");
        month.add("September");
        month.add("October");
        month.add("November");
        month.add("December");

        BarDataSet bardataset = new BarDataSet(Rainfall, "Rainfall in mm");
        chart.animateY(5000);
        bardataset.setValueTextSize(15);
        //chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(year));
        BarData data = new BarData(month,bardataset);
        chart.setDescription("Amount Of rainfall in 2020");
        chart.setDescriptionTextSize(15);
        chart.zoomIn();
        //chart.setDescriptionColor(Color.WHITE);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);


    }


}