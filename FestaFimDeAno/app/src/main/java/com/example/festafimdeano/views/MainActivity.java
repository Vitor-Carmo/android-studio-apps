package com.example.festafimdeano.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.festafimdeano.R;
import com.example.festafimdeano.constant.EndYearsConstants;
import com.example.festafimdeano.data.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private  ViewHolder mViewHolder = new ViewHolder();
    private static SimpleDateFormat SIMPLE_DATE_FORMAT =  new SimpleDateFormat("dd/MM/yyyy");
    private SecurityPreferences mSecurityPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.textToday = findViewById( R.id.text_today );
        this.mViewHolder.textDayLeft = findViewById( R.id.text_days_left );
        this.mViewHolder.buttonConfirm = findViewById( R.id.button_confirm );

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        // today's date
        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()),  getString(R.string.days));
        this.mViewHolder.textDayLeft.setText(daysLeft);

        this.verifyPreference();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPreference();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_confirm){
            String presence = this.mSecurityPreferences.getStoredString(EndYearsConstants.PRESENCE_KEY);

            startActivity( new Intent(this, DetailsActivity.class).putExtra(EndYearsConstants.PRESENCE_KEY, presence));
        }
    }
    private void verifyPreference() {
        String presence = this.mSecurityPreferences.getStoredString(EndYearsConstants.PRESENCE_KEY);
        if(presence.equals("")){
            this.mViewHolder.buttonConfirm.setText(getString(R.string.no_confirmed));
        }else if (presence.equals(EndYearsConstants.CONFIRMATION_YES)){
            this.mViewHolder.buttonConfirm.setText(getString(R.string.yes));
        }else {
            this.mViewHolder.buttonConfirm.setText(getString(R.string.no));
        }
    }

    private int getDaysLeft(){
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        Calendar calendarLastDay = Calendar.getInstance();
        int dayMax = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return dayMax - today;
    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDayLeft;
        Button buttonConfirm;
    }


}