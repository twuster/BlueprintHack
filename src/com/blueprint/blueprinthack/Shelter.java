package com.blueprint.blueprinthack;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class Shelter extends Activity implements Parcelable {
	
	private String name;
	private String address;
	private String hours;
	private String email;
	private String phone;
	
	private TextView name_text, address2, hours2, contact_email, contact_phone;
	
	public Shelter (String name, String address, String hours, String email, String phone){
		this.name = name;
		this.address = address;
		this.hours = hours;
		this.email = email;
		this.phone = phone;
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shelter_info);
        
        name_text = (TextView) findViewById(R.id.name);
        name_text.setText(this.name);
        address2 = (TextView) findViewById(R.id.address2);
        address2.setText(this.address);
        hours2 = (TextView) findViewById(R.id.hours2);
        hours2.setText(this.hours);
        contact_email = (TextView) findViewById(R.id.contact2);
        contact_email.setText(this.email);
        contact_phone = (TextView) findViewById(R.id.contact3);
        contact_phone.setText(this.phone);
    }
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getHours(){
		return this.hours;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPhone(){
		return this.phone;
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
