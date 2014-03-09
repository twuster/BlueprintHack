package com.blueprint.blueprinthack;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.VideoView;

public class PetInfoActivity extends Activity {
	
	private TextView breed, shelter, age;
	private int[] photos;
	private VideoView video;
	private Gallery gallery;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_info);
        
        breed = (TextView) findViewById(R.id.tvBreed);
        shelter = (TextView) findViewById(R.id.tvShelter);
        age = (TextView) findViewById(R.id.tvAge);
        video = (VideoView) findViewById(R.id.pet_video);
        gallery = (Gallery) findViewById(R.id.pet_gallery);
        
        Bundle b = getIntent().getExtras(); 
        Pet pet = b.getParcelable("pet");
        
        breed.setText(pet.getBreed());
        shelter.setText(pet.getBreed());
        age.setText(pet.getAge()+"");
        
        gallery.setSpacing(1);
        gallery.setAdapter(new GalleryImageAdapter(this, pet.getPhotos()));

         // clicklistener for Gallery
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(PetInfoActivity.this, "Your selected position = " + position, Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}
