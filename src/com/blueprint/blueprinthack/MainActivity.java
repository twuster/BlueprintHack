package com.blueprint.blueprinthack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;
import com.facebook.Session;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private int[] pet1photos = { R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4 };
    Shelter shelter1;
    Pet dog1;
    private ArrayList<Pet> allPets;
    private ArrayList<Pet> dogs;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new PetAdapter(this, (Pet[])allPets.toArray()));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                
                Intent openPetInfo = new Intent("com.blueprint.blueprinthack.PetInfoActivity");
                openPetInfo.putExtra("pet", allPets.get(position));
                startActivity(openPetInfo);
            }
        });
        dog1 = new Pet("dog 1", shelter1, 2, pet1photos, R.drawable.sample_1, "android.resource://" + getPackageName() + "/"
                + R.raw.dog_video);
        shelter1 = new Shelter("Shelter 1", "123 Pet Avenue", "Mon-Fri 9am-5pm", "pet@gmail.com", "123-456-7890");
        //Add the pets and dogs here
        allPets.add(dog1);
        dogs.add(dog1);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent i;
        switch(item.getItemId()){
            case(R.id.action_login):
                i = new Intent(this,LoginActivity.class);
                this.startActivity(i);
                break;
            case(R.id.action_logout):
                Session session = Session.getActiveSession();
                session.closeAndClearTokenInformation();
                i = new Intent(this, LoginActivity.class);
                this.startActivity(i);
                break;
            default:
                break;
        }
        return true;
    }
}
