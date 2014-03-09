package com.blueprint.blueprinthack;

import android.os.Parcel;
import android.os.Parcelable;

public class Shelter implements Parcelable {
	
	private String name;
	private String address;
	private String hours;
	private String email;
	private String phone;
	
	public Shelter (String name, String address, String hours, String email, String phone){
		this.name = name;
		this.address = address;
		this.hours = hours;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getHours(){
		return hours;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPhone(){
		return phone;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	
	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { 
		public Pet createFromParcel(Parcel in) { 
			return new Pet(in); 
		}   
		public Pet[] newArray(int size) { 
			return new Pet[size]; 
		} 
	};

}
