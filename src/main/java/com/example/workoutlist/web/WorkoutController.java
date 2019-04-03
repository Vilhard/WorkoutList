package com.example.workoutlist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.workoutlist.domain.Excercise;

@Controller
public class WorkoutController {

	 @RequestMapping(value="/home", method=RequestMethod.GET)
	 public ModelAndView home() {
		 ModelAndView model = new ModelAndView();
		 model.setViewName("home");
	    return model;
	}
	 
	 @RequestMapping(value="/login", method=RequestMethod.GET)
	 public String login() {	
	    return "login";
	}
	 
	 @RequestMapping(value="/index", method=RequestMethod.GET)
	 public String index()	{
		 return "index";
	 }
	 
	 @RequestMapping(value = "/add")
		public String addExcercise(Model model)	{
			model.addAttribute("excercise", new Excercise());
			return "add";
		}
		
	 
}
