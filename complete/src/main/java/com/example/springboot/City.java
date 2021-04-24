package com.example.springboot;

public class City{
	private final int Id;
	private final String Name;
	private final String Province;

	public City(int Id, String Name, String Province){
		this.Id=Id;
		this.Name=Name;
		this.Province=Province;
	}

	public int getId(){
		return Id;
	}

	public String getName(){
		return Name;
	}

	public String getProvince(){
		return Province;
	}
}