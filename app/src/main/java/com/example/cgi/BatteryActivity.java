package com.example.cgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BatteryActivity extends AppCompatActivity {

    TextView textBatteryStatus, textPowerSource, textBatteryLevel, textBatteryHealth, textBatteryVoltage, textBatteryTemperature, textBatteryTechnology;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        textBatteryStatus = (TextView)findViewById(R.id.battery_status);
        textPowerSource = (TextView)findViewById(R.id.power_source);
        textBatteryLevel = (TextView)findViewById(R.id.battery_level);
        textBatteryHealth = (TextView)findViewById(R.id.battery_health);
        textBatteryVoltage = (TextView)findViewById(R.id.battery_voltage);
        textBatteryTemperature = (TextView)findViewById(R.id.battery_temperature);
        textBatteryTechnology = (TextView)findViewById(R.id.battery_technology);

        intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        final BroadcastReceiver br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;

                if(isCharging)
                    textBatteryStatus.setText("Battery Status : charging");
                 else
                    textBatteryStatus.setText("Battery Status : charged full");

                 int powerSource = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                 boolean isUSBCharge = powerSource == BatteryManager.BATTERY_PLUGGED_USB || powerSource == BatteryManager.BATTERY_PLUGGED_AC;

                 if (isUSBCharge)
                     textPowerSource.setText("Power Source : USB");
                 else
                     textPowerSource.setText("Power Source : AC");

                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                float batteryPct = (level/(float) scale)*100;
                textBatteryLevel.setText("Battery level : "+batteryPct+" %");

                int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
                textBatteryVoltage.setText("Battery voltage : "+voltage+" mv");

                int temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
                textBatteryTemperature.setText("Battery temperature : "+temperature+" °F");

                String technology = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
                textBatteryTechnology.setText("Battery technology : "+technology);

                int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);
                switch(health) {
                    case BatteryManager.BATTERY_HEALTH_COLD:textBatteryHealth.setText("Battery health : cold");
                        break;
                    case BatteryManager.BATTERY_HEALTH_DEAD:textBatteryHealth.setText("Battery health : dead");
                        break;
                    case BatteryManager.BATTERY_HEALTH_GOOD:textBatteryHealth.setText("Battery health : good");
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVERHEAT:textBatteryHealth.setText("Battery health : overheat");
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:textBatteryHealth.setText("Battery health : over voltage");
                        break;
                    case BatteryManager.BATTERY_HEALTH_UNKNOWN:textBatteryHealth.setText("Battery health : unknown");
                        break;
                    case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:textBatteryHealth.setText("Battery health : failure");
                        break;
                    default:
                        break;

                }


            }
        };

        BatteryActivity.this.registerReceiver(br, intentFilter);
    }


}
