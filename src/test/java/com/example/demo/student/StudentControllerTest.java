package com.example.demo.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static java.time.Month.OCTOBER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("GET http://localhost:8080/api/v1/student --> HTTP 200")
    void getStudentsTEST() throws Exception {
        /* test GET request, expecting http200 code*/
        this.mockMvc.perform(get("http://localhost:8080/api/v1/student"))
                    .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST http://localhost:8080/api/v1/student --> HTTP 200")
    void postStudentsTEST() throws Exception {

        /*Creating a test student that will be send in TEST post request*/
        Student student = new Student(
                "test",
                "test.test@test.test",
                LocalDate.of(1998, OCTOBER, 13)
        );
        /* test POST request, expecting http200 code*/
        this.mockMvc.perform(post("http://localhost:8080/api/v1/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("DELETE http://localhost:8080/api/v1/student --> HTTP 200")
    void deleteStudent() throws Exception {
        /* test DELETE request, deleting student id "1" ,expecting http200 code*/
        this.mockMvc.perform(delete("http://localhost:8080/api/v1/student/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("PUT http://localhost:8080/api/v1/student --> HTTP 200")
    void updateStudent() throws Exception {

        /* test PUT request, changing student id2's name to "testname" ,expecting http200 code
        * i'm using student id2 in this case, because id1 was deleted above. */

        this.mockMvc.perform(put("http://localhost:8080/api/v1/student/2?name=testname"))
                .andDo(print()).andExpect(status().isOk());
    }


}