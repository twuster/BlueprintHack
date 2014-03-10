package com.blueprint.blueprinthack;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.Log;

/**
 * Created by tony on 3/8/14.
 */
public class LoginActivity extends FragmentActivity {

    private FacebookLoginFragment fbLoginFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        System.out.println("LoginActivity onCreate()");
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.blueprint.blueprinthack", 
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                System.out.println("KeyHash: "+ Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (NameNotFoundException e) {
//        	System.out.println(e.getMessage());        
//        } catch (NoSuchAlgorithmException e) {
//        	System.out.println(e.getMessage());
//        }
        
        if (savedInstanceState == null) {
            // Add the fragment on initial activity setup
            fbLoginFragment = new FacebookLoginFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fbLoginFragment)
                    .commit();
        } else {
            // Or set the fragment from restored state info
            fbLoginFragment = (FacebookLoginFragment) getSupportFragmentManager().findFragmentById(android.R.id.content);
        }
    }

}
