package com.ust.traineeapp.repository;

//import com.mysql.cj.protocol.Resultset;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.util.JdbcConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TraineeRepositoryImpl implements TraineeRepository{

    @Autowired
    private Connection connection;

    public TraineeRepositoryImpl(){
//        connection = JdbcConnectionUtil.createConnection();
    }
    @Override
    public Trainee save(Trainee trainee) {
//        String sql = "insert into trainee(name, location, date_joined) values ('%s', '%s', '%s')"
//                .formatted(trainee.name(), trainee.location(), trainee.date_joined().toString());
        String sql = "insert into trainee(name, location, date_joined) values (?,?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, trainee.name());
            preparedStatement.setString(2, trainee.location());
//            preparedStatement.setString(3, trainee.date_joined().toString());
//            preparedStatement.setString(3, trainee.date_joined().toString());
//            Statement statement = connection.createStatement();
            preparedStatement.setDate(3, Date.valueOf(trainee.date_joined()));
//            int rowCount = statement.executeUpdate(sql);
            int rowCount = preparedStatement.executeUpdate();
            System.out.println(rowCount + " rows inserted");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return trainee;

    }

    @Override
    public Optional<Trainee> getTrainee(int id) {
        String sql = "select * from trainee where id=" + id;
        String name="", location="";
        LocalDate date_joined = null;
        ResultSet resultSet;
        try {
            resultSet = connection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(getTraineeFromResultSet(resultSet));
    }

    @Override
    public List<Trainee> getAllTrainees() {
        String sql = "select * from trainee";
        ResultSet resultset;
        try{
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(sql);
            if(resultset == null)
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getTraineesFromResultSet(resultset);
    }

    @Override
    public void deleteTrainee(int id) {

        String sql = "delete from trainee where id = " + id;
        try {
            connection.createStatement().execute(sql);
            System.out.println("Delete Successful!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Trainee getTraineeFromResultSet(ResultSet resultset){
        Trainee trainee = null;
        try{
            if(resultset.next()){
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                String location = resultset.getString("location");
                LocalDate date_joined = resultset.getDate("date_joined").toLocalDate();
                trainee = new Trainee(id, name, location, date_joined);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trainee;
    }

    public List<Trainee> getTraineesFromResultSet(ResultSet resultset){
        List<Trainee> trainees = new ArrayList<>();
        try{
            while(resultset.next()){
                int id = resultset.getInt("id");
                String name = resultset.getString("name");
                String location = resultset.getString("location");
                LocalDate date_joined = resultset.getDate("date_joined").toLocalDate();
                trainees.add(new Trainee(id, name, location, date_joined));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trainees;
    }
}
