package com.fourav.medal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ClipTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public  void testApiKey() throws Exception {
        this.mockMvc
                .perform( get("/api/medalkey"))
                .andExpect(status().isOk())
                .andExpect( content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").isNotEmpty());
    }

    @Test
    public  void testVideoUrl() throws Exception {
        this.mockMvc
                .perform( get("/api/videolink/414223"))
                .andExpect(status().isOk())
                .andExpect( content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").isNotEmpty())
                .andDo( print() );
    }
}
