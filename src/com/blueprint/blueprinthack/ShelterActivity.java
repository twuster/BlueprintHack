package com.blueprint.blueprinthack;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;

/**
 * Created by tony on 3/8/14.
 */
public class ShelterActivity  extends Activity {

    String TAG = "ShelterActivity";

    private TextView name_text, address, addressField, hours, hoursField, contact, contact_email, contact_phone;
    private Button getDirections, fbShare;
    private UiLifecycleHelper uiHelper;
    private Session.StatusCallback callback = new Session.StatusCallback() {
        @Override
        public void call(Session session, SessionState state, Exception exception) {
            onSessionStateChange(session, state, exception);
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shelter_info);

        uiHelper = new UiLifecycleHelper(this, callback);
        uiHelper.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        Shelter s = b.getParcelable("shelter");

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
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr=" + addressField.getText().toString()));
                startActivity(intent);
            }
        });

        fbShare = (Button) findViewById(R.id.fb_button);
        fbShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(getParent())
                        .setLink("https://www.calblueprint.org")
                        .setName("WOW")
                        .setCaption("I just adopted a pet :D")
                        .setCaption("This app is amazing!")
                        .build();
                uiHelper.trackPendingDialogCall(shareDialog.present());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
            @Override
            public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
                Log.e("Activity", String.format("Error: %s", error.toString()));
            }

            @Override
            public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {
                Log.i("Activity", "Success!");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }

    private void onSessionStateChange(Session session, SessionState state, Exception exception) {
        if (state.isOpened()) {
            Log.i(TAG, "Logged in...");
        } else if (state.isClosed()) {
            Log.i(TAG, "Logged out...");
        }
    }
}
