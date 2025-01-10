package com.ust.webapp.controller;

import com.ust.webapp.model.Trainee;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TraineeController {
//    List<Trainee> traineeList = new ArrayList<>();
//    @PostMapping("/add-trainee")
//    public String addTrainee(Model model, @RequestParam("id") int id,
//                             @RequestParam("name") String name,
//                             @RequestParam("location") String location){
//
//        Trainee trainee = new Trainee(id, name, location);
//        model.addAttribute("trainee", trainee);
//        return "view-trainee.jsp";
//    }

    @Autowired
    TraineeService traineeService;

    @PostMapping("/add-trainee")
    public String addTrainee(@ModelAttribute("trainee") Trainee trainee, Model model){
        traineeService.addTrainee(trainee);
        model.addAttribute("traineeList", traineeService.getAllTrainees());
        return "view-trainee.jsp";
    }

    @GetMapping("/")
    public String getAddTrainee(){
        return "addTrainee.jsp";
    }

}
