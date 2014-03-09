package com.blueprint.blueprinthack;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PetVideo extends Activity {
	
	VideoView video;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);
        video = (VideoView) findViewById(R.id.pet_video);
        String uri = getIntent().getExtras().getString("videoURI");
        playVideo(uri);
	}
	
	public void playVideo(String uri){
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
        VideoView videoHolder = new VideoView(this);
        //if you want the controls to appear
        videoHolder.setMediaController(new MediaController(this));
        Uri video = Uri.parse(uri); //do not add any extension
        //if your file is named sherif.mp4 and placed in /raw
        //use R.raw.sherif
        videoHolder.setVideoURI(video);
        setContentView(videoHolder);
        videoHolder.start();
	}

}
