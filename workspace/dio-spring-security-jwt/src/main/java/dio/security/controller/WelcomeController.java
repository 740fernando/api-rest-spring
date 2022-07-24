package dio.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.security.model.ClientUser;
import dio.security.service.ClientUserService;

@RestController
@RequestMapping
public class WelcomeController {

	@GetMapping
	public String welcome() {
		return "Welcome to My Spring Boot Web Api";
	}

	@GetMapping("/users")
	public String users() {
		return "Authorized user";
	}
	
	@GetMapping("/managers")
	public String managers() {
		return "Authorized manager";
	}
}
