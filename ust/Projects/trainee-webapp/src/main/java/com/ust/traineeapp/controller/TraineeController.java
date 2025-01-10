package com.ust.traineeapp.controller;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import com.ust.traineeapp.repository.TraineeRepositoryImpl;
import com.ust.traineeapp.util.JdbcConnectionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;

@WebServlet("/trainees/*")
public class TraineeController extends HttpServlet {
    TraineeRepository traineeRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        traineeRepository = new TraineeRepositoryImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path =req.getRequestURI();
        System.out.println(path);
        if(path.contains("/add"))
            addTrainee(req,resp);
        else if(path.contains("/get"))
            getTrainee(req, resp);
        else if(path.contains("/delete"))
            deleteTrainee(req, resp);
    }

    private void getTrainee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("trainees", traineeRepository.getAllTrainees());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view-trainees.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void addTrainee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String location = req.getParameter("location");
        LocalDate joindate = LocalDate.parse(req.getParameter("joindate"));

        Trainee trainee = new Trainee(id, name, location, joindate);

        traineeRepository.save(trainee);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/success.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void deleteTrainee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        traineeRepository.deleteTrainee(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/trainee-webapp/trainees/get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);

//        PrintWriter out = resp.getWriter();
//        out.println("""
//                <html>
//                    <head>
//                        <title>Test Document</title>
//                    </head>
//                    <body>
//                        <h1>Hello %s</h1>
//                    </body>
//                </html>
//                """.formatted(name));


    }



}
