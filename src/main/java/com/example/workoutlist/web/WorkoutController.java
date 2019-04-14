package com.example.workoutlist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.workoutlist.domain.Exercise;
import com.example.workoutlist.domain.ExercisePojo;
import com.example.workoutlist.domain.ExerciseRepository;
import com.example.workoutlist.domain.Weekday;

@Controller
public class WorkoutController {

	@Autowired
	private ExerciseRepository erepository;

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
		List<Exercise> exercises = erepository.findAllOrderByWeekdayid();
		model.addAttribute("exercises", exercise2exercisePojo(exercises));
		return "index";
	}

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

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addExercise(Model model) {
		// Create new List<String>
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

	// Edit exercise
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editExercise(@PathVariable("id") Long id, Model model) {
		List<String> weekdays = new ArrayList<>();
		weekdays.add("Maanantai");
		weekdays.add("Tiistai");
		weekdays.add("Keskiviikko");
		weekdays.add("Torstai");
		weekdays.add("Perjantai");
		weekdays.add("Lauantai");
		weekdays.add("Sunnuntai");
		//	Adding attributes to model 
		model.addAttribute("weekdays", weekdays);
		//	Overwrite selected exercise with new data
		
		model.addAttribute("exercisepojo", erepository.findById(id));
		model.addAttribute("exercise", new ExercisePojo());
		return "edit";
	}

	// Save exercise to database
	@PostMapping("/save")
	public String save(ExercisePojo exercise) {
		Exercise exercisee = exercisePojo2exercise(exercise);
		erepository.save(exercisee);
		return "redirect:index";
	}

	// Map ExcerciePojo to Entity
	private Exercise exercisePojo2exercise(ExercisePojo excercise) {
		Exercise exe = new Exercise();
		exe.setId(excercise.getId());
		exe.setName(excercise.getName());
		exe.setReps(excercise.getReps());
		exe.setSets(excercise.getSets());
		exe.setDay(Weekday.getByName(excercise.getWeekday()));
		return exe;
	};

	// Delete Exercise by id
	@GetMapping("/delete/{id}")
	public String deleteExercise(@PathVariable("id") Long id, Model model) {
		erepository.deleteById(id);
		return "redirect:../index";
	}
}
