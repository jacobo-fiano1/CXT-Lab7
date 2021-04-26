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
	private final List<Country> countries = new ArrayList<Country>();

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

		Country a = new Country(1, "Espana", "Madrid");
		Country b = new Country(2, "Francia", "Paris");
		Country c = new Country(3, "Italia", "Roma");
		Country d = new Country(4, "Grecia", "Atenas");
		Country e = new Country(5, "Croacia", "Zagreb");
		Country f = new Country(6, "Malta", "La Valeta");
		Country g = new Country(7, "Albania", "Tirana");
		Country h = new Country(8, "Chipre", "Nicosia");
		Country i = new Country(9, "Eslovenia", "Ljubliana");
		Country j = new Country(10, "Montenegro", "Podgorica");

		this.countries.add(a);
		this.countries.add(b);
		this.countries.add(c);
		this.countries.add(d);
		this.countries.add(e);
		this.countries.add(f);
		this.countries.add(g);
		this.countries.add(h);
		this.countries.add(i);
		this.countries.add(j);
	}

	@GetMapping("/cities")
	public List<City> List_cities() {
		
        return this.cities;
	}

	@GetMapping("/cities/{id}")
	public City City(@PathVariable int id) {
		return cities.get(id-1);
	}

	@GetMapping("/countries")
	public List<Country> List_countries() {
		return this.countries;
	}

	@GetMapping("/countries/{id}")
	public Country countriesg(@PathVariable int id) {
		return countries.get(id-1);
	}

}
