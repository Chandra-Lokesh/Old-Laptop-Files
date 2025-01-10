package service;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import com.ust.traineeapp.service.TraineeService;
import com.ust.traineeapp.service.TraineeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TraineeServiceTest {

    @Mock
    TraineeRepository traineeRepository;

    @InjectMocks
    TraineeServiceImpl traineeService;

    @Test
    public void saveTraineeTest(){
        Trainee trainee = new Trainee(20, "name1", "mumbai", LocalDate.of(2004, 02, 19));
        when(traineeRepository.save(trainee)).thenReturn(trainee);
        assertEquals(trainee, traineeService.saveTrainee(trainee));
        verify(traineeRepository, times(1)).save(trainee);
    }

    @Test
    public void getTraineeByIdTest(){
        Trainee trainee = new Trainee(20, "name1", "mumbai", LocalDate.of(2004, 02, 19));
//        when(traineeRepository.getTrainee(5)).thenReturn(Optional.empty());
        when(traineeRepository.getTrainee(20)).thenReturn(Optional.of(trainee));
        assertEquals(traineeService.getTraineeById(20), Optional.of(trainee));
        verify(traineeRepository, times(1)).getTrainee(20);
    }

    @Test
    public void getAllTraineesTest(){
        Trainee t1 = new Trainee(20, "name1", "mumbai", LocalDate.of(2004, 02, 19));
        Trainee t2 = new Trainee(21, "name1", "pune", LocalDate.of(2005, 02, 19));
        Trainee t3 = new Trainee(22, "name1", "hyderabad", LocalDate.of(2006, 02, 19));
        Trainee t4 = new Trainee(23, "name1", "noida", LocalDate.of(2007, 02, 19));
        when(traineeRepository.getAllTrainees()).thenReturn(List.of(t1, t2, t3, t4));
        assertEquals(traineeService.getAllTrainees(), List.of(t1, t2, t3, t4));
        verify(traineeRepository, times(1)).getAllTrainees();
    }

    @Test
    public void deleteTraineeTest(){
        doNothing().when(traineeRepository).deleteTrainee(20);
        traineeService.deleteTrainee(20);
        verify(traineeRepository, times(1)).deleteTrainee(20);
    }

}