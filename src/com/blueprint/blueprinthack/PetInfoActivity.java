package com.blueprint.blueprinthack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class PetInfoActivity extends Activity {
	
	Context c;
	private TextView breed, shelter, age, videoTitle, breedTitle, shelterTitle, ageTitle;
	private int[] photos;
	private Button videoButton;
	private Gallery gallery;
	private int width, height;
    Typeface myTypeface;


    private Pet pet;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_info);
        c = getApplicationContext();

        myTypeface = Typeface.createFromAsset(getAssets(), "fonts/oregano.ttf");
        
        breed = (TextView) findViewById(R.id.tvBreed);
        breed.setTypeface(myTypeface);
        shelter = (TextView) findViewById(R.id.tvShelter);
        shelter.setTypeface(myTypeface);
        age = (TextView) findViewById(R.id.tvAge);
        age.setTypeface(myTypeface);
        videoTitle = (TextView) findViewById(R.id.video);
        videoTitle.setTypeface(myTypeface);
        breedTitle = (TextView) findViewById(R.id.breed);
        breedTitle.setTypeface(myTypeface);
        shelterTitle = (TextView) findViewById(R.id.shelter);
        shelterTitle.setTypeface(myTypeface);
        ageTitle = (TextView) findViewById(R.id.age);
        ageTitle.setTypeface(myTypeface);

        videoButton = (Button) findViewById(R.id.play_video);
        gallery = (Gallery) findViewById(R.id.pet_gallery);
        
        Bundle b = getIntent().getExtras(); 
        pet = b.getParcelable("pet");
        
        breed.setText(pet.getBreed());
        shelter.setText(pet.getShelter().getName());
        age.setText(pet.getAge()+"");
        
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        
        gallery.setSpacing(1);
        gallery.setAdapter(new GalleryImageAdapter(this, pet.getPhotos(), width, height));

         // clicklistener for Gallery
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(PetInfoActivity.this, "Your selected position = " + position, Toast.LENGTH_SHORT).show();
            }
        });
        
        videoButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				Intent openVideo = new Intent(c, PetVideo.class);
//				openVideo.putExtra("videoURI", pet.getVideo());
//				startActivity(openVideo);
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v=ofeynC2SAXg")));
			    System.out.println("Video Playing....");
			}
        });
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pet_menu, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent i;
        switch(item.getItemId()){
            case(R.id.action_adopt):
            	Intent openShelterInfo = new Intent(c, ShelterActivity.class);
            	openShelterInfo.putExtra("shelter", pet.getShelter());
            	startActivity(openShelterInfo);
                break;
            default:
                break;
        }
        return true;
    }
}
