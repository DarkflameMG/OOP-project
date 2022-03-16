package com.carin.carinProject;

import com.carin.carinProject.classes.TestGame;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class CarinProjectApplication {
	
	public static void main(String[] args) throws SyntaxError, IOException, TokenizerError {
		SpringApplication.run(CarinProjectApplication.class, args);
		TestGame.main(args);
	}	
}
