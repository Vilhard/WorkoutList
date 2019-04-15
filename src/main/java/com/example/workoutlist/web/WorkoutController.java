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
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}

	// Show login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	// Order exercises by id
	@RequestMapping("/index")
	public String index(Model model) {
		List<Exercise> exercises = erepository.findAllOrderByWeekdayid();
		model.addAttribute("exercises", exercise2exercisePojo(exercises));
		return "index";
	}

	// Map ExcercisePojo to Entity
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

	private Exercise exercisePojo2exercise(ExercisePojo exercise) {
		Exercise exe = new Exercise();
		exe.setId(exercise.getId());
		exe.setName(exercise.getName());
		exe.setReps(exercise.getReps());
		exe.setSets(exercise.getSets());
		exe.setDay(Weekday.getByName(exercise.getWeekday()));
		return exe;
	};

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
	public String save(ExercisePojo exercise) {
		Exercise exercisee = exercisePojo2exercise(exercise);
		erepository.save(exercisee);
		return "redirect:index";
	}

	// Delete Exercise by id
	@GetMapping("/delete/{id}")
	public String deleteExercise(@PathVariable("id") Long id, Model model) {
		erepository.deleteById(id);
		return "redirect:../index";
	}

	// REST get all exercises
	@GetMapping("/exercises")
	public @ResponseBody List<Exercise> ExerciseListRest() {
		return (List<Exercise>) erepository.findAll();
	}

	// REST get exercise by id
	@GetMapping("/exercise/{id}")
	public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("id") Long id) {
		return erepository.findById(id);
	}
}
