package com.example.workoutlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkoutController {

	 @RequestMapping(value="/home", method=RequestMethod.GET)
	 public ModelAndView index() {
		 ModelAndView model = new ModelAndView();
		 model.setViewName("home");
	    return model;
	}
	 
	 @RequestMapping(value="/login")
	 public String login() {	
	    return "login";
	}
}
