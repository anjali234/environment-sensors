package com.example.user.environment;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.app.Activity;
import android.hardware.SensorManager;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends Activity implements SensorEventListener {
    private Sensor mPressure;

    private SensorManager manager;
    private Sensor accelerometer;
    private float x;
    private float y;
    private float z;
    private float normalizedValue;
    long timestamp;
    private LineGraphSeries<DataPoint> mSeries;
    private LineGraphSeries<DataPoint> mSeries2;
    private LineGraphSeries<DataPoint> mSeries3;
    private LineGraphSeries<DataPoint> mSeries4;
    //shows unfiltered accelerometer data
    private GraphView graph;
    //shows filtered accelerometer data
    private GraphView graph2;
    private GraphView graph3;
    private GraphView graph4;
    private double lastXValue = 5d;
    //Variable to store appended data points
    float data[] = new float[500];
    double timestamps[] = new double[500];
    double coefficients[];
    static int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graph = (GraphView) findViewById(R.id.graph);
        graph2 = (GraphView) findViewById(R.id.graph2);
        manager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Setting GraphView Viewport layouts
        Viewport gViewport =  graph.getViewport();
        Viewport gViewport2 = graph2.getViewport();
        gViewport.setXAxisBoundsManual(true);
        gViewport.setMinX(0);
        gViewport.setScrollable(true);
        gViewport.setMinY(0);
        gViewport.setScalable(true);
        // activate horizontal and vertical zooming and scrolling
        gViewport.setScalableY(true);
        // activate vertical scrolling
        gViewport.setScrollableY(true);
        gViewport2.setXAxisBoundsManual(true);
        gViewport2.setMinX(0);
        gViewport2.setScrollable(true);
        gViewport2.setMinY(0);
        gViewport2.setScalable(true);
        // activate horizontal and vertical zooming and scrolling
        gViewport2.setScalableY(true);
        // activate vertical scrolling
        gViewport2.setScrollableY(true);
        //add blank mseries to graph
        mSeries = new LineGraphSeries<>();
        //mseries features
        mSeries.setTitle("Acceleration curve");
        mSeries.setColor(Color.GREEN);
        mSeries.setDrawDataPoints(true);
        mSeries.setDataPointsRadius(10);
        mSeries.setThickness(8);
        graph.addSeries(mSeries);
        mSeries2 = new LineGraphSeries<>();
        //mseries features
        mSeries2.setTitle("Filtered curve");
        mSeries2.setColor(Color.BLUE);
        mSeries2.setDrawDataPoints(true);
        mSeries2.setDataPointsRadius(7);
        mSeries2.setThickness(6);
        graph2.addSeries(mSeries2);

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = manager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    private void gViewport() {

    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_PRESSURE){
            x=sensorEvent.values[0];
            y=sensorEvent.values[1];
            z=sensorEvent.values[2];
            normalizedValue = (float) Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
            timestamp=System.currentTimeMillis();
            lastXValue += 1d;
            //Append data to plot graph whenever there is a change i acceleration plots upto 500 data changes
            mSeries.appendData(new DataPoint(lastXValue,normalizedValue), true, 500);
            while(index < 500) {
                data[index] = normalizedValue;
                timestamps[index] = lastXValue;
                index++;
                break;
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            x=sensorEvent.values[0];
            y=sensorEvent.values[1];
            z=sensorEvent.values[2];
            normalizedValue = (float) Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
            timestamp=System.currentTimeMillis();
            lastXValue += 1d;
            //Append data to plot graph whenever there is a change i acceleration plots upto 500 data changes
            mSeries.appendData(new DataPoint(lastXValue,normalizedValue), true, 500);
            while(index < 500) {
                data[index] = normalizedValue;
                timestamps[index] = lastXValue;
                index++;
                break;
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_LIGHT){
            x=sensorEvent.values[0];
            y=sensorEvent.values[1];
            z=sensorEvent.values[2];
            normalizedValue = (float) Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
            timestamp=System.currentTimeMillis();
            lastXValue += 1d;
            //Append data to plot graph whenever there is a change i acceleration plots upto 500 data changes
            mSeries.appendData(new DataPoint(lastXValue,normalizedValue), true, 500);
            while(index < 500) {
                data[index] = normalizedValue;
                timestamps[index] = lastXValue;
                index++;
                break;
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType()==Sensor.TYPE_AMBIENT_TEMPERATURE){
            x=sensorEvent.values[0];
            y=sensorEvent.values[1];
            z=sensorEvent.values[2];
            normalizedValue = (float) Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
            timestamp=System.currentTimeMillis();
            lastXValue += 1d;
            //Append data to plot graph whenever there is a change i acceleration plots upto 500 data changes
            mSeries.appendData(new DataPoint(lastXValue,normalizedValue), true, 500);
            while(index < 500) {
                data[index] = normalizedValue;
                timestamps[index] = lastXValue;
                index++;
                break;
            }
        }
    }
    
    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        manager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        manager.unregisterListener(this);
    }
}


