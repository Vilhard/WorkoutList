package com.example.workoutlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.workoutlist.domain.Excercise;
import com.example.workoutlist.domain.ExcerciseRepository;
import com.example.workoutlist.domain.WeekdayRepository;

@Controller
public class WorkoutController {

	@Autowired
	private ExcerciseRepository erepository;

	@Autowired
	private WeekdayRepository wdrepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("excercises", erepository.findAll());
		return "index";
	}

	@RequestMapping(value = "/add")
	public String addExcercise(Model model) {
		model.addAttribute("excercise", new Excercise());
		model.addAttribute("weekday", wdrepository.findAll());
		return "add";
	}

	@PostMapping("/save")
	public String save(Excercise excercise) {
		erepository.save(excercise);
		return "redirect:index";
	}

	// Delete Excercise
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		erepository.deleteById(id);
		return "redirect:../index";
	}
}
