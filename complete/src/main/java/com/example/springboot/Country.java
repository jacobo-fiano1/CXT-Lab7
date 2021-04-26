package com.example.springboot;

public class Country{
	private final int Id;
	private final String Name;
	private final String Capital;

	public Country(int Id, String Name, String Capital){
		this.Id=Id;
		this.Name=Name;
		this.Capital=Capital;
	}

	public int getId(){
		return Id;
	}

	public String getName(){
		return Name;
	}

	public String getCapital(){
		return Capital;
	}
}
