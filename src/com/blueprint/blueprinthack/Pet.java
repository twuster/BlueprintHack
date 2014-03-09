package com.blueprint.blueprinthack;

import android.os.Parcel;
import android.os.Parcelable;

public class Pet implements Parcelable {
	
	private String breed;
	private Shelter shelter;
	private int age;
	private int[] photos;
	private int profilePhoto;
	//temp variable for video
	private String videoURI;
	
	public Pet(String breed, Shelter shelter, int age, int[] photos, int profilePhoto){
		this.breed = breed;
		this.shelter = shelter;
		this.age = age;
		this.photos = photos;
		this.profilePhoto = profilePhoto;
		this.videoURI = null;
	}
	
	public Pet(String breed, Shelter shelter, int age, int[] photos, int profilePhoto, String video){
		this.breed = breed;
		this.shelter = shelter;
		this.age = age;
		this.photos = photos;
		this.profilePhoto = profilePhoto;
		this.videoURI = video;
	}
	
	public Pet(Parcel in) { 
		readFromParcel(in); 
	}
	
	@Override 
	public void writeToParcel(Parcel dest, int flags) { 
		dest.writeString(breed); 
		dest.writeParcelable(shelter, flags);
		dest.writeInt(age);
		dest.writeIntArray(photos);
		dest.writeInt(profilePhoto);
		dest.writeString(videoURI);
	}   
	
	private void readFromParcel(Parcel in) {
		breed = in.readString(); 
		shelter = (Shelter)in.readParcelable(Shelter.class.getClassLoader());
		age = in.readInt();
		//in.readIntArray(photos);
		photos = in.createIntArray();
		profilePhoto = in.readInt();
		videoURI = in.readString();
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { 
		public Pet createFromParcel(Parcel in) { 
			return new Pet(in); 
		}   
		public Pet[] newArray(int size) { 
			return new Pet[size]; 
		} 
	};
	
	public String getBreed(){
		return breed;
	}
	
	public Shelter getShelter(){
		return shelter;
	}
	
	public int getAge(){
		return age;
	}
	
	public int getProfilePhoto(){
		return profilePhoto;
	}
	
	public int[] getPhotos(){
		return photos;
	}

	public String getVideo(){
		return videoURI;
	}

	@Override
	public int describeContents() {
		return 0;
	}
}
