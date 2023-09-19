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

// Ingegration test class for NotesApplication
@SpringBootTest
// Auto-configure a MockMvc instance
@AutoConfigureMockMvc
class NotesApplicationTests {

	@Autowired
    // MockMvc is the main entry point for server-side Spring MVC test support
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
        // Assert that the MockMvc instance is not null
		assertNotNull(mockMvc);
	}

	@Test
    // Test the TaskController (API) 
	public void testGetTask() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/api/task/1");

        // Perform the request and assert the status
		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful()
				);

	}

	@Test
    // Test the NotesController (API)
	public void testGetNote() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/api/note/1");

        // Perform the request and assert the status
		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful()
				);

	}

	@Test
    // Test the GUI
    // The GUI is the default page
	public void testGetGUI() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/");

        // Perform the request and assert the status, view and model
		mockMvc.perform(request)
				.andExpect(status().is2xxSuccessful())
				.andExpect(view().name("notes"))
				.andExpect(model().attributeExists("notesTasks"))
				;

	}
}
