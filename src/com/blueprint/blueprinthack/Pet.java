package com.blueprint.blueprinthack;

public class Pet {
	
	private String breed;
	private Shelter shelter;
	private int age;
	private Integer[] photos;
	//temp variable for video
	private String video;
	
	public Pet(String breed, Shelter shelter, int age, Integer[] photos){
		this.breed = breed;
		this.shelter = shelter;
		this.age = age;
		this.photos = photos;
		this.video = null;
	}
	
	public Pet(String breed, Shelter shelter, int age, Integer[] photos, String video){
		this.breed = breed;
		this.shelter = shelter;
		this.age = age;
		this.photos = photos;
		this.video = video;
	}

}
