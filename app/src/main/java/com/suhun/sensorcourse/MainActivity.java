package com.suhun.sensorcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private TextView v1, v2, v3;
    private SensorManager sensorManager;
    private Sensor sensor;
    private MyListener myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
//
//        for(Sensor sensor:sensors){
//            String name = sensor.getName();
//            String type = sensor.getStringType();
//            Log.d(tag, "----name:"+name+", type"+ type+"----");
//        }
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onStart() {
        super.onStart();
        myListener = new MyListener();

        sensorManager.registerListener(myListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(myListener!=null) {
            sensorManager.unregisterListener(myListener);
        }
    }

    private void initView(){
        v1 = findViewById(R.id.lid_v1);
        v2 = findViewById(R.id.lid_v2);
        v3 = findViewById(R.id.lid_v3);
    }

    private class MyListener implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] v = event.values;
            v1.setText("X="+v[0]);
            v2.setText("Y="+v[1]);
            v3.setText("Z="+v[2]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
}