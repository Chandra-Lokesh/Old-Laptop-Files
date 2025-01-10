package com.ust.traineeapp.service;

import com.ust.traineeapp.exception.RecordNotFoundException;
import com.ust.traineeapp.service.TraineeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TraineeServiceImplTest {

    @Autowired
    TraineeServiceImpl traineeService;

    @Test
    void getTraineeByIdTest(){
        var id = 1;
        Assertions.assertDoesNotThrow(() -> traineeService.getTrainee(id));
        Assertions.assertThrows(RecordNotFoundException.class, () -> traineeService.getTrainee(10));
    }
}
