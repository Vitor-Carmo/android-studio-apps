package com.example.festafimdeano.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.festafimdeano.R;
import com.example.festafimdeano.constant.EndYearsConstants;
import com.example.festafimdeano.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    // passar o contexto dentro do on create pois aqui fora ainda está nulo
    private SecurityPreferences mSecurityPreferences;
    private ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.mViewHolder.AreYouGoingParticipate = findViewById(R.id.check_box_are_u_going_participate);

        this.mViewHolder.AreYouGoingParticipate.setOnClickListener(this);

        this.mSecurityPreferences = new SecurityPreferences(this);
        this.loadDataFromActivity();

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_box_are_u_going_participate ){
            if (this.mViewHolder.AreYouGoingParticipate.isChecked()){
                this.mSecurityPreferences.storeString(EndYearsConstants.PRESENCE_KEY, EndYearsConstants.CONFIRMATION_YES);
            }else  {
                this.mSecurityPreferences.storeString(EndYearsConstants.PRESENCE_KEY, EndYearsConstants.CONFIRMATION_NO);

            }
        }
    }

    private void loadDataFromActivity() {
        Bundle  extras = getIntent().getExtras();
        if (extras != null){
            String presence = extras.getString(EndYearsConstants.PRESENCE_KEY);
            this.mViewHolder.AreYouGoingParticipate.setChecked(presence != null && presence.equals(EndYearsConstants.CONFIRMATION_YES));
        }
    }

    private static class ViewHolder {
        CheckBox AreYouGoingParticipate;
    }


}