
package in.mahabhujal.mahabhujal;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;


public class PieChart extends AppCompatActivity {

    PieChartView pieChartView1,pieChartView2,pieChartView3,pieChartView4,pieChartView5,pieChartView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        pieChartView1 = findViewById(R.id.chart1);
        pieChartView2 = findViewById(R.id.chart2);
        pieChartView3 = findViewById(R.id.chart3);
        pieChartView4 = findViewById(R.id.chart4);
        pieChartView5 = findViewById(R.id.chart5);
        pieChartView6 = findViewById(R.id.chart6);


        process();


    }

    private void process() {

        List pieData1 = new ArrayList<>();
        pieData1.add(new SliceValue(60, Color.BLUE).setLabel("Working: 276"));
        pieData1.add(new SliceValue(40, Color.DKGRAY).setLabel("Not Working: 91"));


        PieChartData pieChartData = new PieChartData(pieData1);
        pieChartData.setHasLabelsOnlyForSelected(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Borewell Functioning").setCenterText1FontSize(13).setCenterText1Color(Color.parseColor("#0B0A0C"));
        pieChartView1.setPieChartData(pieChartData);



        //------------2----------------//

        List pieData2 = new ArrayList<>();
        pieData2.add(new SliceValue(66, Color.BLUE).setLabel("Working: 7"));
        pieData2.add(new SliceValue(22, Color.RED).setLabel("Not Working: 2"));



        PieChartData pieChartData2 = new PieChartData(pieData2);
        pieChartData2.setHasLabelsOnlyForSelected(true).setValueLabelTextSize(14);
        pieChartData2.setHasCenterCircle(true).setCenterText1("Well Functioning").setCenterText1FontSize(13).setCenterText1Color(Color.parseColor("#0B0A0C"));
        pieChartView2.setPieChartData(pieChartData2);
        pieChartView2.setChartRotationEnabled(true);



        //------------3----------------//

        List pieData3 = new ArrayList<>();
        pieData3.add(new SliceValue(75, Color.GREEN).setLabel("Domestic: 276"));
        pieData3.add(new SliceValue(24, Color.YELLOW).setLabel("Agriculture: 91"));
        pieData3.add(new SliceValue(1, Color.BLUE).setLabel("Other: 0"));



        PieChartData pieChartData3 = new PieChartData(pieData3);
        pieChartData3.setHasLabelsOnlyForSelected(true).setValueLabelTextSize(14);
        pieChartData3.setHasCenterCircle(true).setCenterText1("Borewell Usage").setCenterText1FontSize(13).setCenterText1Color(Color.parseColor("#0B0A0C"));
        pieChartView3.setPieChartData(pieChartData3);
        pieChartView3.setChartRotationEnabled(true);


        //------------4----------------//

        List pieData4 = new ArrayList<>();
        pieData4.add(new SliceValue(57, Color.DKGRAY).setLabel("Domestic: 4"));
        pieData4.add(new SliceValue(42, Color.BLUE).setLabel("Agriculture: 3"));
        pieData4.add(new SliceValue(1, Color.RED).setLabel("Other: 0"));



        PieChartData pieChartData4 = new PieChartData(pieData4);
        pieChartData4.setHasLabelsOnlyForSelected(true).setValueLabelTextSize(14);
        pieChartData4.setHasCenterCircle(true).setCenterText1("Well Usage").setCenterText1FontSize(13).setCenterText1Color(Color.parseColor("#0B0A0C"));
        pieChartView4.setPieChartData(pieChartData4);
        pieChartView4.setChartRotationEnabled(true);

        //------------5----------------//

        List pieData5 = new ArrayList<>();
        pieData5.add(new SliceValue(50, Color.GREEN).setLabel("Private: 185"));
        pieData5.add(new SliceValue(25, Color.YELLOW).setLabel("Shared: 91"));
        pieData5.add(new SliceValue(25, Color.GRAY).setLabel("Common: 91"));



        PieChartData pieChartData5 = new PieChartData(pieData5);
        pieChartData5.setHasLabelsOnlyForSelected(true).setValueLabelTextSize(14);
        pieChartData5.setHasCenterCircle(true).setCenterText1("Borewell Ownership").setCenterText1FontSize(13).setCenterText1Color(Color.parseColor("#0B0A0C"));
        pieChartView5.setPieChartData(pieChartData5);
        pieChartView5.setChartRotationEnabled(true);


        //------------6----------------//

        List pieData6 = new ArrayList<>();
        pieData6.add(new SliceValue(95, Color.BLUE).setLabel("Private: 7"));
        pieData6.add(new SliceValue(1, Color.YELLOW).setLabel("Shared: 0"));
        pieData6.add(new SliceValue(1, Color.GRAY).setLabel("Common: 0"));



        PieChartData pieChartData6 = new PieChartData(pieData6);
        pieChartData6.setHasLabelsOnlyForSelected(true).setValueLabelTextSize(14);
        pieChartData6.setHasCenterCircle(true).setCenterText1("Well Ownership").setCenterText1FontSize(13).setCenterText1Color(Color.parseColor("#0B0A0C"));
        pieChartView6.setPieChartData(pieChartData6);
        pieChartView6.setChartRotationEnabled(true);











    }


}


/*
private static final String TAG = "TAG";
    float barSpace = 0.02f;
    float groupSpace = 0.3f;
    List<String> rainList = new ArrayList<>();
    List<String> dates = new ArrayList<>();
    BarChart barChart;
   // ProgressBar progressBar;
    Button switchChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        barChart= findViewById(R.id.bar_chart);
        switchChart = findViewById(R.id.check_graph);
        switchChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            getChartData(switchChart.getText().toString());
            }
        });

    }


    private void getChartData(final String type){
        ApiInterface apiInterface= ApiClient.getRetrofit().create(ApiInterface.class);
        Call<ChartResponse> call=apiInterface.getChartResponse();
        call.enqueue(new Callback<ChartResponse>() {
            @Override
            public void onResponse(Call<ChartResponse> call, Response<ChartResponse> response) {
                Gson gson=new GsonBuilder().create();
                TypeToken<List<String>> typeTokenRainOnDates=new TypeToken<List<String>>(){};

                //rainList.clear();
                setBarChart(rainList,dates,"rainfall");

                   // rainList=gson.fromJson(gson.fromJson(response.body().getRainResponse())),typeTokenRainOnDates.getType());

            }

            @Override
            public void onFailure(Call<ChartResponse> call, Throwable t) {

            }
        });


    }

    private void setBarChart(List<String> dataSets , List<String> groupList, String type) {

        int[] MyColors = {
                getResources().getColor(R.color.black),
                getResources().getColor(R.color.red),
                getResources().getColor(R.color.brown),
                getResources().getColor(R.color.dark_blue),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.green),
                getResources().getColor(R.color.yellow),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.orange),
                getResources().getColor(R.color.colorPrimaryDark),

    };

        ArrayList<BarDataSet> arrayList=new ArrayList<>();
        for (int i=0;i<dataSets.size();i++) {

            BarDataSet barDataSet = new BarDataSet(barEntries(dataSets.get(i), groupList, type), dataSets.get(i));
            barDataSet.setColor(MyColors[i]);
            barDataSet.setValueTextSize(6f);
            arrayList.add(barDataSet);

        }

        BarData barData=new BarData();
        for(int i=0;i<arrayList.size();i++){
            barData.addDataSet(arrayList.get(i));
        }
        barData.setValueTextSize(7f);
        barChart.setData(barData);
        barChart.setPinchZoom(true);
        barChart.setDrawGridBackground(false);
        XAxis xAxis=barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(groupList));
        xAxis.setPosition(XAxis.XAxisPosition.TOP);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        xAxis.setDrawGridLines(true);

        barData.setBarWidth(0.2f);
        Legend legend=barChart.getLegend();
        legend.setTextSize(10);
        legend.setWordWrapEnabled(true);

        barChart.setVisibleXRangeMaximum(3);
        barChart.getXAxis().setAxisMinimum(0);

        float defaultBarWidth;
        int groupCount=groupList.size();

        defaultBarWidth=(1-groupSpace)/arrayList.size()-barSpace;
        if (defaultBarWidth>=0){
            barData.setBarWidth(defaultBarWidth);
        }
        if (groupCount!=-1){
            barChart.getXAxis().setAxisMinimum(0);
            barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace,barSpace)*groupList.size());
        }

        if (barData.getDataSetCount()>1){
            barChart.groupBars(0,groupSpace,barSpace);
        }

        barChart.invalidate();



    }

    private List<BarEntry> barEntries(String groupName, List<String> groupList, String type){
    ArrayList<BarEntry> arrayList=new ArrayList<>();
    int i=0;
    while (i<groupList.size()){
        for(RainDataModel r:rainList) {
            if (r.getRainfall().equals(groupName)) {
                BarEntry barEntry = new BarEntry(i, Float.parseFloat(r.getRainfall()));
                arrayList.add(barEntry);
                i++;
            }
        }
        }
            return arrayList;

    }
 */
       /*
        pieChart = (PieChart) findViewById(R.id.piechart);
        //pieChart.setUsePercentValues(true);
        barChart = (BarChart) findViewById(R.id.barchart);
        lineChart=(LineChart)findViewById(R.id.line);
        RewardApi();
    }


    /*
    public void RewardApi() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://codeplayon.com/service1.asmx/PointSummary", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    progressDialog.dismiss();
                    String status = jsonObject.getString("status");
                    String mgs = jsonObject.getString("msg");
                    if (status.equals("1")) {
                        //swipeRefreshLayout.setRefreshing(false);
                        progressDialog.dismiss();
                        // Toast.makeText(getApplicationContext(),mgs,Toast.LENGTH_LONG).show();
                        a= jsonObject.getJSONObject("ot").getString("E");
                        b= jsonObject.getJSONObject("ot").getString("R");
                        c= jsonObject.getJSONObject("ot").getString("Balance");

                        /*=======for pie chart=========*/

/*
                        ArrayList<Entry> yvalues = new ArrayList<Entry>();
                        yvalues.add(new Entry(Float.parseFloat(a), 0));
                        yvalues.add(new Entry(Float.parseFloat(b), 1));
                        yvalues.add(new Entry(Float.parseFloat(c), 2));

                        PieDataSet dataSet = new PieDataSet(yvalues, "");

                        ArrayList<String> xVals = new ArrayList<String>();
                        xVals.add("Earned");
                        xVals.add("Redeemed");
                        xVals.add("Balance");

                        PieData data = new PieData(xVals, dataSet);
                        data.setValueFormatter(new DefaultValueFormatter(0));
                        pieChart.setData(data);
                        //pieChart.setDescription("This is Pie Chart");

                        pieChart.setDrawHoleEnabled(true);
                        pieChart.setTransparentCircleRadius(25f);
                        pieChart.setHoleRadius(25f);

                        dataSet.setColors(ColorTemplate.LIBERTY_COLORS);
                        data.setValueTextSize(8f);
                        data.setValueTextColor(Color.DKGRAY);
                        pieChart.setOnChartValueSelectedListener(Graph_Avtiv.this);
                        pieChart.animateXY(1400, 1400);

                        /*========for barchart========*/

/*

                        ArrayList<BarEntry> entries = new ArrayList<>();
                        entries.add(new BarEntry(Float.parseFloat(a), 0));
                        entries.add(new BarEntry(Float.parseFloat(b), 1));
                        entries.add(new BarEntry(Float.parseFloat(c), 2));

                        BarDataSet dataset = new BarDataSet(entries, "");

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add("Earned");
                        labels.add("Redeemed");
                        labels.add("Balance");

                        BarData bardata = new BarData(labels, dataset);
                        dataset.setColors(ColorTemplate.JOYFUL_COLORS);
                        barChart.setData(bardata);
                        barChart.animateY(5000);
                        barChart.animateX(3000);

                        /*=======for line chart==========*/

/*

                        ArrayList<Entry> entries1 = new ArrayList<>();
                        entries1.add(new Entry(Float.parseFloat(a), 0));
                        entries1.add(new Entry(Float.parseFloat(b), 1));
                        entries1.add(new Entry(Float.parseFloat(c), 2));
                        entries1.add(new Entry(0, 3));

                        LineDataSet dataset1 = new LineDataSet(entries1, "");

                        ArrayList<String> labels1 = new ArrayList<String>();
                        labels1.add("Earned");
                        labels1.add("Redeemed");
                        labels1.add("Balance");
                        labels1.add("Others");

                        LineData data1 = new LineData(labels1, dataset1);
                        dataset1.setColors(ColorTemplate.COLORFUL_COLORS);
                        lineChart.setData(data1);
                        lineChart.animateY(5000);
                        lineChart.animateX(3000);
                        /*=====for cubic form========*/

/*
                        dataset1.setDrawCubic(true);
                        /*========Fill the color below the line=========*/

/*
                        dataset1.setDrawFilled(true);
                        //  lineChart.setDescription(&quot;Description&quot;);

                    } else {
                        // swipeRefreshLayout.setRefreshing(false);
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), mgs, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //swipeRefreshLayout.setRefreshing(false);
                        progressDialog.dismiss();
                        Toast.makeText(Graph_Avtiv.this, "Internet Connection Lost,Please Try Again", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("UserId", "2");
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

<ProgressBar
        android:id="@+id/progress_circular"
        android:layout_width="136dp"
        android:layout_height="133dp"
        android:layout_gravity="center"
        android:visibility="gone"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

*/