package com.blueprint.blueprinthack;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by tony on 3/8/14.
 */
public class LoginActivity extends FragmentActivity {

    private FacebookLoginFragment fbLoginFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            fbLoginFragment = new FacebookLoginFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fbLoginFragment)
                    .commit();
        } else {
            // Or set the fragment from restored state info
            fbLoginFragment = (FacebookLoginFragment) getSupportFragmentManager()
                    .findFragmentById(android.R.id.content);
        }
    }

}
