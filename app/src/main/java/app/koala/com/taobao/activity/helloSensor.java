package app.koala.com.taobao.activity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import app.koala.com.taobao.R;

/**
 * Created by Chaos on 3/26/2015.
 */
public class helloSensor extends Activity {
    Sensor sensor;

    private float x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hellosensor);

        final TextView tx1 = (TextView)findViewById(R.id.textView1);

        SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> allSensors = sm.getSensorList(Sensor.TYPE_ALL);

        tx1.setText("经检测该手机有"+allSensors.size()+"个传感器，他们分别是:\n");
        for (Sensor item : allSensors){

        }

        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorEventListener lsn = new SensorEventListener(){
            @Override
            public void onSensorChanged(SensorEvent event) {
                x = event.values[SensorManager.DATA_X];
                y = event.values[SensorManager.DATA_Y];
                z = event.values[SensorManager.DATA_Z];
                setTitle("x=" + (int)x + ", y=" + (int)y + ", z=" + (int)z);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        sm.registerListener(lsn,sensor,SensorManager.SENSOR_DELAY_GAME);
    }
}
