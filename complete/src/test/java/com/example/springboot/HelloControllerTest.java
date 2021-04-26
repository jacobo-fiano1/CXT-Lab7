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
				.andExpect(content().string("[{\"name\":\"Coruna\",\"id\":1,\"province\":\"A Coruna\"},{\"name\":\"Vigo\",\"id\":2,\"province\":\"Pontevedra\"},{\"name\":\"Santiago\",\"id\":3,\"province\":\"A Coruna\"},{\"name\":\"Ferrol\",\"id\":4,\"province\":\"A Coruna\"},{\"name\":\"Lugo\",\"id\":5,\"province\":\"Lugo\"},{\"name\":\"Ourense\",\"id\":6,\"province\":\"Ourense\"},{\"name\":\"Pontevedra\",\"id\":7,\"province\":\"Pontevedra\"}]"));
	}

	@Test
	public void getCitybyId() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/cities/{id}",1).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("{\"name\":\"Coruna\",\"id\":1,\"province\":\"A Coruna\"}"));
	}
}
