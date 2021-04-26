package com.example.springboot;

import java.util.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloController {
    
	private final List<City> cities = new ArrayList<City>();

	public HelloController(){
		City A = new City(1, "Coruna", "A Coruna");
		City B = new City(2, "Vigo", "Pontevedra");
		City C = new City(3, "Santiago", "A Coruna");
		City D = new City(4, "Ferrol", "A Coruna");
		City E = new City(5, "Lugo", "Lugo");
		City F = new City(6, "Ourense", "Ourense");
		City G = new City(7, "Pontevedra", "Pontevedra");
		
		this.cities.add(A);
		this.cities.add(B);
		this.cities.add(C);
		this.cities.add(D);
		this.cities.add(E);
		this.cities.add(F);
		this.cities.add(G);
	}

	@GetMapping("/cities")
	public List<City> List_cities() {
		
        return this.cities;
	}

	@GetMapping("/cities/{id}")
	public City City(@PathVariable int id) {
		return cities.get(id-1);
	}

}
