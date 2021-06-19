
/*
package in.mahabhujal.mahabhujal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Random;

import in.mahabhujal.mahabhujal.ui.dashboard.dashboardFragment;

public class BarGraphDemo extends Fragment {


    private static final int MAX_X_VALUE = 12;
    private static final int MAX_Y_VALUE = 50;
    private static final int MIN_Y_VALUE = 5;
    private static final String SET_LABEL = "Rainfall Amount";
    //private static final String[] DAYS = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    private static final String[] MONTH = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL","AUG","SEPT","OCT","NOV","DEC" };


    private BarChart chart;
    private PieChart chart2;

    private BarData createChartData() { ArrayList<BarEntry> values = new ArrayList<>();
        Random rd = new Random();

        for (int i = 0; i < MAX_X_VALUE; i++) {
            float x = i;
            float y = rd.nextFloat();
            values.add(new BarEntry(x, y));
        }

        BarDataSet set1 = new BarDataSet(values, SET_LABEL);

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        BarData data = new BarData(dataSets);


        return data;
    }



    private void prepareChartData(BarData data) {
        data.setValueTextSize(12f);
        chart.setData(data);
        chart.invalidate();
    }


    // TODO: Rename and change types and number of parameters
    public static dashboardFragment newInstance(String param1, String param2) {
        dashboardFragment fragment = new dashboardFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private void configureChartAppearance() {
        chart.getDescription().setEnabled(false);
        chart.setDrawValueAboveBar(false);

        XAxis xAxis = chart.getXAxis();

        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return MONTH[(int) value];
            }
        });

        YAxis axisLeft = chart.getAxisLeft();
        axisLeft.setGranularity(10f);
        axisLeft.setAxisMinimum(0);

        YAxis axisRight = chart.getAxisRight();
        axisRight.setGranularity(10f);
        axisRight.setAxisMinimum(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_bargraphdemo, container, false);

        //Chart 1
        chart = view.findViewById(R.id.fragment_verticalbarchart_chart);
        BarData data = createChartData();
        configureChartAppearance();
        prepareChartData(data);
        return view;
    }
}

 */
