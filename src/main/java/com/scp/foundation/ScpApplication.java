package com.scp.foundation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScpApplication.class, args);
	}
	
	@GetMapping("/hi")
	public String hi(@RequestParam(value = "name", defaultValue ="World") String name) {
		return String.format("Hello %s!", name);
	}
}
