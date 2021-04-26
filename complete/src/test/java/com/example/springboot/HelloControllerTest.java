package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getCities() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/cities").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"name\":\"Coruna\",\"id\":1,\"province\":\"A Coruna\"},{\"name\":\"Vigo\",\"id\":2,\"province\":\"Pontevedra\"},{\"name\":\"Santiago\",\"id\":3,\"province\":\"A Coruna\"},{\"name\":\"Ferrol\",\"id\":4,\"province\":\"A Coruna\"},{\"name\":\"Lugo\",\"id\":5,\"province\":\"Lugo\"},{\"name\":\"Ourense\",\"id\":6,\"province\":\"Ourense\"},{\"name\":\"Pontevedra\",\"id\":7,\"province\":\"Pontevedra\"}]"));
	}

	@Test
	public void getCitybyId() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/cities/{id}",1).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("{\"name\":\"Coruna\",\"id\":1,\"province\":\"A Coruna\"}"));
	}

	@Test
	public void getCountries() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/countries").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("[{\"name\":\"Espana\",\"id\":1,\"capital\":\"Madrid\"},{\"name\":\"Francia\",\"id\":2,\"capital\":\"Paris\"},{\"name\":\"Italia\",\"id\":3,\"capital\":\"Roma\"},{\"name\":\"Grecia\",\"id\":4,\"capital\":\"Atenas\"},{\"name\":\"Croacia\",\"id\":5,\"capital\":\"Zagreb\"},{\"name\":\"Malta\",\"id\":6,\"capital\":\"La Valeta\"},{\"name\":\"Albania\",\"id\":7,\"capital\":\"Tirana\"},{\"name\":\"Chipre\",\"id\":8,\"capital\":\"Nicosia\"},{\"name\":\"Eslovenia\",\"id\":9,\"capital\":\"Ljubliana\"},{\"name\":\"Montenegro\",\"id\":10,\"capital\":\"Podgorica\"}]"));
	}

	@Test
	public void getCountry() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/countries/{id}",1).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"name\":\"Espana\",\"id\":1,\"capital\":\"Madrid\"}"));
	}
}
