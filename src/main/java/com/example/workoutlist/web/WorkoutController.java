package com.example.workoutlist.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.workoutlist.domain.Exercise;
import com.example.workoutlist.domain.ExercisePojo;
import com.example.workoutlist.domain.ExerciseRepository;
import com.example.workoutlist.domain.Weekday;

@Controller
public class WorkoutController {

	@Autowired
	private ExerciseRepository erepository;

	// Show home page
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	// Show login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// Map ExcercisePojo to Entity
	private Exercise exercisePojo2exercise(ExercisePojo exercisepojo) {
		Exercise exe = new Exercise();
		exe.setId(exercisepojo.getId());
		exe.setName(exercisepojo.getName());
		exe.setReps(exercisepojo.getReps());
		exe.setSets(exercisepojo.getSets());
		exe.setDay(Weekday.getByName(exercisepojo.getWeekday()));
		return exe;
	};

	private List<ExercisePojo> exercise2exercisePojo(List<Exercise> exercises) {
		List<ExercisePojo> returnList = new ArrayList<>();
		for (Exercise e : exercises) {
			ExercisePojo pojo = new ExercisePojo();
			pojo.setId(e.getId());
			pojo.setName(e.getName());
			pojo.setReps(e.getReps());
			pojo.setSets(e.getSets());
			pojo.setWeekday(Weekday.getByValue(e.getDay()));
			returnList.add(pojo);
		}
		return returnList;
	};

	// Order exercises by id
	@RequestMapping("/home")
	public String index(Model model) {
		List<Exercise> exercises = erepository.findAllOrderByWeekdayid();
		model.addAttribute("exercises", exercise2exercisePojo(exercises));
		return "home";
	}

	// Add new exercise
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addExercise(Model model) {
		// List to show weekdays
		List<String> weekdays = new ArrayList<>();
		model.addAttribute("exercise", new ExercisePojo());
		weekdays.add("Maanantai");
		weekdays.add("Tiistai");
		weekdays.add("Keskiviikko");
		weekdays.add("Torstai");
		weekdays.add("Perjantai");
		weekdays.add("Lauantai");
		weekdays.add("Sunnuntai");
		model.addAttribute("weekdays", weekdays);
		return "add";
	}

	// Save exercise to database
	@PostMapping("/save")
	public String save(ExercisePojo exercisepojo) {
		Exercise exercisee = exercisePojo2exercise(exercisepojo);
		erepository.save(exercisee);
		return "redirect:home";
	}

	// Delete Exercise by id
	@GetMapping("/delete/{id}")
	public String deleteExercise(@PathVariable("id") Long id, Model model) {
		erepository.deleteById(id);
		return "redirect:../home";
	}

	// REST get all exercises
	@GetMapping("/exercises")
	public @ResponseBody List<Exercise> ListRest() {
		return (List<Exercise>) erepository.findAll();
	}

	// REST get exercise by id
	@GetMapping("/exercise/{id}")
	public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("id") Long id) {
		return erepository.findById(id);
	}
}
