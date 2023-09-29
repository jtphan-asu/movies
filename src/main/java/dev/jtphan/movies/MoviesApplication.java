package dev.jtphan.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //States that this API is an REST API controller
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@GetMapping("/root")
	//GetMapping annotation lets framework know that it is a GET
	//endpoint
	public String apiRoot(){
		return "Hello, World!";
	}
}
