package com.example.juhwan.axivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ResultActivity extends Activity {

    private RelativeLayout mainLayout;
    private PieChart mChart;
    // we're going to display pie chart for smartphones martket shares
    private int[] yData = new int[3];
    private String[] xData = { "Sit", "Run", "Walk" };

    int sit = 0;
    int walk = 0;
    int run = 0;

    String day = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
//        mChart = new PieChart();
        // add pie chart to main layout


        Intent fromIntent = getIntent();

        sit = fromIntent.getIntExtra("sit",1);
        walk = fromIntent.getIntExtra("walk",1);
        run = fromIntent.getIntExtra("run",1);

        day = fromIntent.getStringExtra("timeday");

        yData[0] = sit;
        yData[1] = run;
        yData[2] = walk;

        String walk1 = String.valueOf(walk);
        String sit1 = String.valueOf(sit);
        String run1 = String.valueOf(run);

        Log.i("resulttttt111:::" , walk1);
        Log.i("resulttttt222:::" , sit1);
        Log.i("resulttttt222:::" , run1);
        Log.i("resulttttttt333:::", day);

        mChart = (PieChart)findViewById(R.id.mChart);


//        mainLayout.addView(mChart);
        mainLayout.setBackgroundColor(Color.parseColor("#55656C"));

        // configure pie chart
        mChart.setUsePercentValues(true);
        mChart.setDescription(day +"Result");
        mChart.setDescriptionTextSize(50);

        // enable hole and configure
        mChart.setDrawHoleEnabled(true);
//        mChart.setHoleColorTransparent(true);
        mChart.setHoleRadius(15);
        mChart.setTransparentCircleRadius(10);


        // enable rotation of the chart by touch
        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        // set a chart value selected listener
        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                // display msg when value selected
                if (e == null)
                    return;

                int count = (int)e.getVal();

                Toast.makeText(ResultActivity.this,
                        xData[e.getXIndex()] + " = " + count + "번", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        // add data
        addData();

        // customize legends
        Legend l = mChart.getLegend();
        l.setForm(Legend.LegendForm.CIRCLE);
        l.setPosition(Legend.LegendPosition.ABOVE_CHART_RIGHT);
//        l.setXEntrySpace(3);
//        l.setYEntrySpace(3);
        l.setTextSize(15f);
    }

    private void addData() {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < yData.length; i++)
            yVals1.add(new Entry(yData[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);

        // create pie data set
//        PieDataSet dataSet = new PieDataSet(yVals1, "Daily State");
        PieDataSet dataSet = new PieDataSet(yVals1, null);
        dataSet.setSliceSpace(7);
//        dataSet.setSelectionShift(3);

        dataSet.setValueTextSize(15f);

        // add many colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

//        colors.add(Color.RED);
//        colors.add(Color.BLUE);
//        colors.add(Color.YELLOW);

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

//        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        // instantiate pie data object now
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());

        data.setValueTextSize(15f);
        data.setValueTextColor(Color.GRAY);

        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        // update pie chart
        mChart.invalidate();
    }

}