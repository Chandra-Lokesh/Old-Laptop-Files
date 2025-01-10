package com.ust.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Controller
public class AppController {

    @GetMapping("/hello")
    public String sayHello(Model model, @RequestParam("username") String username){ //ModelAndView
        String time = LocalTime.now().toString();
        model.addAttribute("time", time);
        model.addAttribute("username", username);
//        ModelAndView modelAndView = new ModelAndView("hello.jsp");
//        modelAndView.addObject("time", time);
//        modelAndView.addObject("username", username);
        return "hello.jsp";
//        return modelAndView;
    }

//    @GetMapping("/")
//    public String getIndex(){
//        return "index.html";
//    }
}
