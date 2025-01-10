package com.ust.traineeapp.api;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.service.TraineeServiceImpl;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(TraineeController.class)
@ExtendWith(SpringExtension.class)
class TraineeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TraineeServiceImpl traineeService;

    @Test
    void getTrainee() throws Exception{

        //Give
        Trainee trainee = new Trainee(1, "Harsh", "Kerala", LocalDate.now());
        int id = 1;
        int invalidId=100;


        //When
        Mockito.when(traineeService.getTrainee(id)).thenReturn(trainee);

        //Then

        mockMvc.perform(get("/api/v1/trainees/"+id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(id)))
                .andExpect(jsonPath("$.name", Matchers.is(trainee.getName())))
                .andExpect(jsonPath("$.location", Matchers.is(trainee.getLocation())))
                .andExpect(jsonPath("$.joinedDate", Matchers.is(trainee.getJoinedDate().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")))))
                .andReturn();

        mockMvc.perform(get("/api/v1/trainees/"+invalidId))
                .andExpect(status().isNotFound())
                .andReturn();


    }
}