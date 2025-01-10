package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.service.TraineeService;
import com.ust.traineeapp.service.TraineeServiceImpl;
import com.ust.traineeapp.util.JdbcConnectionUtil;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TraineeRepositoryImpl implements TraineeRepository {

//    List<Trainee> trainees = new ArrayList<>();
    Connection connection;

    public TraineeRepositoryImpl(){
        connection = JdbcConnectionUtil.createConnection();
    }


    public Trainee save(Trainee trainee) {

        String query = "insert into trainee values (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, trainee.getId());
            preparedStatement.setString(2, trainee.getName());
            preparedStatement.setString(3, trainee.getLocation());
            preparedStatement.setDate(4, Date.valueOf(trainee.getJoinedDate()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return trainee;

//        trainees.add(trainee);
//        return trainee;
    }

    public Optional<Trainee> getTrainee(int id) {

        String query = "select * from trainee where id="+id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return Optional.of(resultSetToTrainee(resultSet));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



//        return trainees.stream().filter(trainee -> trainee.id() == id).findFirst();

    }

    public List<Trainee> getAllTrainees() {
        String query = "select * from trainee";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return resultSetToTraineeList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTrainee(int id) {
        String query = "delete from trainee where id=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Trainee resultSetToTrainee(ResultSet resultSet){
        try {
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("name");
                LocalDate date = resultSet.getDate("date_joined").toLocalDate();
                return new Trainee(id, name, location, date);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Trainee> resultSetToTraineeList(ResultSet resultSet){
        List<Trainee> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String location = resultSet.getString("name");
                LocalDate date = resultSet.getDate("date_joined").toLocalDate();
                list.add(new Trainee(id, name, location, date));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

}



