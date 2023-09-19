package com.todo.notes;


import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class NotesApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
		assertNotNull(mockMvc);
	}

	@Test
	public void testGetTask() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/api/task/1");

		mockMvc.perform(request)
			.andExpect(status().is2xxSuccessful()
			//.andExpect(model().name(put the name))
			//.andExpect(view().attributeExists(put the attribute));
			);

	}

}
