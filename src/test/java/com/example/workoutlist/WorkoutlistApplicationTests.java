package com.example.workoutlist;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.workoutlist.domain.ExerciseRepository;
import com.example.workoutlist.web.WorkoutController;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkoutlistApplicationTests {

	@MockBean
	ExerciseRepository eRepository;

	@Autowired
	private WorkoutController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
