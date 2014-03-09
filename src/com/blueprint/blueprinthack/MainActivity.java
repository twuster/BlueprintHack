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

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new PetAdapter(this, allPets));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                
                Intent openPetInfo = new Intent("com.blueprint.blueprinthack.PetInfoActivity");
                openPetInfo.putExtra("pet", allPets[position]);
                startActivity(openPetInfo);
            }
        });
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
<<<<<<< HEAD
    
=======

>>>>>>> 00597e07a472258b4615f7d72b97bc585b468c01
    private int[] pet1photos = { R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4 };
    Shelter shelter1 = new Shelter("Shelter 1", "123 Pet Avenue", "Mon-Fri 9am-5pm", "pet@gmail.com", "123-456-7890");
    Pet dog1 = new Pet("dog 1", shelter1, 2, pet1photos, R.drawable.sample_1, "android.resource://" + getPackageName() + "/" 
    		+ R.raw.dog_video);
    private Pet[] allPets = {dog1, dog1, dog1, dog1};
    private Pet[] dogs = {};
<<<<<<< HEAD
    
=======
>>>>>>> 00597e07a472258b4615f7d72b97bc585b468c01

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
