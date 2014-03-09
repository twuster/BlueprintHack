package com.blueprint.blueprinthack;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by tony on 3/8/14.
 */
public class ShelterActivity  extends Activity {

    private TextView name_text, address, addressField, hours, hoursField, contact, contact_email, contact_phone;
    private Button getDirections, fbShare;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shelter_info);

        Bundle b = getIntent().getExtras();
        Shelter s = b.getParcelable("shelter");

        if(s==null){
        	System.out.println("s is null");
        }

        name_text = (TextView) findViewById(R.id.name);
        name_text.setText(s.getName());
        address = (TextView) findViewById(R.id.address);
        addressField = (TextView) findViewById(R.id.address_field);
        addressField.setText(s.getAddress());
        hours = (TextView) findViewById(R.id.hours);
        hoursField = (TextView) findViewById(R.id.hours_field);
        hoursField.setText(s.getHours());
        contact = (TextView) findViewById(R.id.contact);
        contact_email = (TextView) findViewById(R.id.contact_email);
        contact_email.setText(s.getEmail());
        contact_phone = (TextView) findViewById(R.id.contact_phone);
        contact_phone.setText(s.getPhone());

        getDirections = (Button) findViewById(R.id.directions_button);
        getDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fbShare = (Button) findViewById(R.id.fb_button);
        fbShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
