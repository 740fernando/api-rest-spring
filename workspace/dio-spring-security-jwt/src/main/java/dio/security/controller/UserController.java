package dio.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.security.model.ClientUser;
import dio.security.service.ClientUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final ClientUserService clientUserService;
	
	public UserController(ClientUserService clientUserService) {
		this.clientUserService = clientUserService;
	}
	
	@PostMapping
	public void postUser(@RequestBody ClientUser user) {
		clientUserService.createUser(user);
	}
}
