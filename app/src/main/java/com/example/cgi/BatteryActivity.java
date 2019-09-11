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
                    textBatteryStatus.setText("Statut  : en charge");
                 else
                    textBatteryStatus.setText("Statut  : chargé");

                 int powerSource = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                 boolean isUSBCharge = powerSource == BatteryManager.BATTERY_PLUGGED_USB || powerSource == BatteryManager.BATTERY_PLUGGED_AC;

                 if (isUSBCharge)
                     textPowerSource.setText("Power Source : USB");
                 else
                     textPowerSource.setText("Power Source : AC");

                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                int scale = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                float batteryPct = (level/(float) scale)*100;
                textBatteryLevel.setText("Niveau batterie : "+batteryPct+" %");

                int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, -1);
                textBatteryVoltage.setText("Voltage : "+voltage+" mv");

                int temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, -1);
                int temperatureCelsius = (temperature-32)/2;
                textBatteryTemperature.setText("Température : "+temperatureCelsius+" °C");

                String technology = intent.getStringExtra(BatteryManager.EXTRA_TECHNOLOGY);
                textBatteryTechnology.setText("Type de batterie : "+technology);

                int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);
                switch(health) {
                    case BatteryManager.BATTERY_HEALTH_COLD:textBatteryHealth.setText("Santé batterie : froide");
                        break;
                    case BatteryManager.BATTERY_HEALTH_DEAD:textBatteryHealth.setText("Santé batterie : morte");
                        break;
                    case BatteryManager.BATTERY_HEALTH_GOOD:textBatteryHealth.setText("Santé batterie : bonne");
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVERHEAT:textBatteryHealth.setText("Santé batterie : en surchauffe");
                        break;
                    case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE:textBatteryHealth.setText("Santé batterie : hors voltage");
                        break;
                    case BatteryManager.BATTERY_HEALTH_UNKNOWN:textBatteryHealth.setText("Santé batterie : inconnue");
                        break;
                    case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE:textBatteryHealth.setText("Santé batterie : erreur");
                        break;
                    default:
                        break;
                }
            }
        };

        BatteryActivity.this.registerReceiver(br, intentFilter);
    }


}
