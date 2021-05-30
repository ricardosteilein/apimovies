package com.texoit.ricardo;



import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.texoit.ricardo.controller.MainController;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MainControllerIntegrationTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private MainController MainController;
	
    @Autowired
    protected WebApplicationContext wa;
	
	@Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.MainController).build();
        	 mockMvc = MockMvcBuilders.webAppContextSetup(wa).build();
    }

	/* É esperado que produtor com menor interavalo seja Joel Silver. E o maior intervalo seja Matthew Vaughn */
    @Test
    public void getAwardsIntervalMinProducerTest() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.get("/producer/awards-interval").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect( jsonPath("$.min.*.producer", hasItem( is( "Joel" ))))
            ;
    }
    
    @Test
    public void getAwardsIntervalMaxProducerTest() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.get("/producer/awards-interval").contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect( jsonPath("$.max.*.producer", hasItem( is( "Matthew Vaughn" ))))
            ;
    }
    
}
