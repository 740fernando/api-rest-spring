package dio.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.spring.security.utils.ConstantsUtils;

@RestController
public class LoginController implements ConstantsUtils {

	@GetMapping
	public String welcome() {
		return WELCOME_TO_MY_SPRING_BOOT_WEB_API;
	}
	
	@GetMapping("/users")
	public String users() {
		return AUTHORIZED_USER;
	}
	
	@GetMapping("/managers")
	public String managers() {
		return AUTHORIZED_MANAGER;
	}
	
}
