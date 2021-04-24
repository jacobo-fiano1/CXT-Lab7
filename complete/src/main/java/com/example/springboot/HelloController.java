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
		City A = new City(1, "Coruña", "A Coruña");
		City B = new City(2, "Vigo", "Pontevedra");
		City C = new City(3, "Santiago", "A Coruña");
		City D = new City(4, "Ferrol", "A Coruña");
		City E = new City(5, "Lugo", "Lugo");
		
		this.cities.add(A);
		this.cities.add(B);
		this.cities.add(C);
		this.cities.add(D);
		this.cities.add(E);
	}

	@GetMapping("/cities")
	public List<String> List_cities() {
		List<String> names= new ArrayList<String>();
		for(City city:cities){
			names.add(city.getName());
		}

        return names;
	}

		@GetMapping("/cities/{id}")
	public City greeting(@PathVariable int id) {
		return cities.get(id-1);
	}

}
