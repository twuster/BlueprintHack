package com.blueprint.blueprinthack;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SearchView;
import com.facebook.Session;

import java.util.ArrayList;

public class MainActivity extends Activity {

	Context c;
    private int[] pet1photos = { R.drawable.pet_dog_1, R.drawable.pet_dog_2, R.drawable.pet_dog_3, R.drawable.pet_dog_1, R.drawable.pet_dog_2 };
    private int[] pet2photos = { R.drawable.pet_rabbit_1, R.drawable.pet_rabbit_2, R.drawable.pet_rabbit_3, R.drawable.pet_rabbit_1, R.drawable.pet_rabbit_2 };
    Shelter shelter1, shelter2, shelter3, shelter4, shelter5;
    Pet dog1, dog2, dog3, dog4, dog5, dog6, pet1, pet2, pet3, pet4, pet5, pet6;
    Pet cat, rabbit;
    private ArrayList<Pet> allPets = new ArrayList<Pet>();
    private ArrayList<Pet> dogs = new ArrayList<Pet>();
    private int width;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        c = this.getApplicationContext();
        
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;

        shelter1 = new Shelter(getResources().getString(R.string.shelter1), getResources().getString(R.string.address1), 
        		getResources().getString(R.string.hours1), getResources().getString(R.string.email1),
        		getResources().getString(R.string.phone1));
        shelter2 = new Shelter(getResources().getString(R.string.shelter2), getResources().getString(R.string.address2), 
        		getResources().getString(R.string.hours2), getResources().getString(R.string.email2),
        		getResources().getString(R.string.phone2));
        shelter3 = new Shelter(getResources().getString(R.string.shelter3), getResources().getString(R.string.address3), 
        		getResources().getString(R.string.hours3), getResources().getString(R.string.email3),
        		getResources().getString(R.string.phone3));
        shelter4 = new Shelter(getResources().getString(R.string.shelter4), getResources().getString(R.string.address4), 
        		getResources().getString(R.string.hours4), getResources().getString(R.string.email4),
        		getResources().getString(R.string.phone4));
        shelter5 = new Shelter(getResources().getString(R.string.shelter5), getResources().getString(R.string.address5), 
        		getResources().getString(R.string.hours5), getResources().getString(R.string.email5),
        		getResources().getString(R.string.phone5));
        
        dog1 = new Pet("dog 1", shelter1, 2, pet1photos, R.drawable.pet_dog1, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        dog2 = new Pet("dog 2", shelter2, 3, pet1photos, R.drawable.pet_dog2, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        dog3 = new Pet("dog 2", shelter3, 1, pet1photos, R.drawable.pet_dog3, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        dog4 = new Pet("pet 1", shelter4, 2, pet1photos, R.drawable.pet_dog4, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        dog5 = new Pet("dog 2", shelter5, 3, pet1photos, R.drawable.pet_dog5, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        dog6 = new Pet("dog 2", shelter1, 1, pet1photos, R.drawable.pet_dog6, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        pet1 = new Pet("pet 1", shelter2, 2, pet2photos, R.drawable.pet_1, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        pet2 = new Pet("dog 2", shelter3, 3, pet1photos, R.drawable.pet_2, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        pet3 = new Pet("dog 2", shelter4, 1, pet1photos, R.drawable.pet_3, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        pet4 = new Pet("pet 1", shelter5, 2, pet1photos, R.drawable.pet_4, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        pet5 = new Pet("dog 2", shelter1, 3, pet1photos, R.drawable.pet_5, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        pet6 = new Pet("dog 2", shelter2, 1, pet1photos, R.drawable.pet_6, "android.resource://" + getPackageName() + "/" + R.raw.dog_video);
        
        //Add the pets and dogs here
        allPets.add(pet1);
        allPets.add(dog1);
        allPets.add(pet2);
        allPets.add(pet6);
        allPets.add(pet3);
        allPets.add(dog2);
        allPets.add(dog5);
        allPets.add(pet4);
        allPets.add(dog3);
        allPets.add(dog4);
        allPets.add(dog6);
        allPets.add(pet5);
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        dogs.add(dog5);
        dogs.add(dog6);
        
        GridView gridview = (GridView) findViewById(R.id.gridview);
        Pet[] allPetsArray = new Pet[allPets.size()];
        allPetsArray = allPets.toArray(allPetsArray);
        gridview.setAdapter(new PetAdapter(this, allPetsArray, (width)/2));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                
                Intent openPetInfo = new Intent(c, PetInfoActivity.class);
                openPetInfo.putExtra("pet", allPets.get(position));
                startActivity(openPetInfo);
            }
        });
        
        handleIntent(getIntent());
    }
    
//    @Override
//    protected void onNewIntent(Intent intent) {
//        handleIntent(intent);
//    }
    
    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            System.out.println("query: " + query);
            if(query.equals("dog")){
            	System.out.println("changing grid to dogs");
            	Pet[] dogsArray = new Pet[dogs.size()];
                dogsArray = dogs.toArray(dogsArray);
                GridView gridview = (GridView) findViewById(R.id.gridview);
                gridview.setAdapter(new PetAdapter(this, dogsArray, (width)/2));

                gridview.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        //Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                        
                        Intent openPetInfo = new Intent(c, PetInfoActivity.class);
                        openPetInfo.putExtra("pet", dogs.get(position));
                        startActivity(openPetInfo);
                    }
                });
            }else{
//            	GridView gridview = (GridView) findViewById(R.id.gridview);
//                Pet[] allPetsArray = new Pet[allPets.size()];
//                allPetsArray = allPets.toArray(allPetsArray);
//                gridview.setAdapter(new PetAdapter(this, allPetsArray, (width)/2));
//
//                gridview.setOnItemClickListener(new OnItemClickListener() {
//                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                        //Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//                        
//                        Intent openPetInfo = new Intent(c, PetInfoActivity.class);
//                        openPetInfo.putExtra("pet", allPets.get(position));
//                        startActivity(openPetInfo);
//                    }
//                });
            }
        }
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		// Associate searchable configuration with the SearchView
	    SearchManager searchManager =
	           (SearchManager) getSystemService(Context.SEARCH_SERVICE);
	    SearchView searchView =
	            (SearchView) menu.findItem(R.id.action_search).getActionView();
	    searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
		return true;
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent i;
        switch(item.getItemId()){
//            case(R.id.action_login):
//                i = new Intent(this,LoginActivity.class);
//                this.startActivity(i);
//                break;
            case(R.id.action_logout):
                Session session = Session.getActiveSession();
                if(session != null){
                    session.closeAndClearTokenInformation();
                }
                i = new Intent(this, LoginActivity.class);
                this.startActivity(i);
                break;
            default:
                break;
        }
        return true;
    }
      
    @Override
    public void onPause(){
//        Session session = Session.getActiveSession();
//        if(session == null){
//            Intent i = new Intent(this, LoginActivity.class);
//            this.startActivity(i);
//        }
        super.onPause();
    }

}
