package com.currencyinformation.currencyinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Settingsfornot extends AppCompatActivity {

    TextView settings_txt_toremoveadd,settings_txt_notification;
    SwitchCompat setting_switch_sma,setting_switch_ef,setting_switch_cd,setting_switch_five,setting_switch_fifteen,setting_switch_hour,setting_switch_day;
Boolean sma_switch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingsfornot);

getSupportActionBar().hide();

settings_txt_toremoveadd=findViewById(R.id.settings_txt_toremoveadd);
        settings_txt_notification=findViewById(R.id.settings_txt_notification);
setting_switch_sma=findViewById(R.id.setting_switch_sma);
        setting_switch_ef=findViewById(R.id.setting_switch_ef);
        setting_switch_cd=findViewById(R.id.setting_switch_cd);
        setting_switch_five=findViewById(R.id.setting_switch_five);
        setting_switch_fifteen=findViewById(R.id.setting_switch_fifteen);
        setting_switch_hour=findViewById(R.id.setting_switch_hour);
        setting_switch_day=findViewById(R.id.setting_switch_day);

        settings_txt_toremoveadd.setText("Subscribe to remove add and alerts based on custom overbrought/ oversold conditions");
settings_txt_notification.setText("Receive Alert on TimeFrames and Indicators");


sma_switch=setting_switch_sma.isChecked();

Model model=new Model();
model.setSwitch_sma(sma_switch);

        Toast.makeText(this, "done"+sma_switch, Toast.LENGTH_SHORT).show();

    }
}