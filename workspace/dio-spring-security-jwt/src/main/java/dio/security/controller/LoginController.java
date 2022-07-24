package dio.security.controller;

import java.util.Date;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dio.security.dto.request.Login;
import dio.security.dto.response.Session;
import dio.security.repository.ClientUserRepository;
import dio.security.security.JWTCreator;
import dio.security.security.JWTObject;
import dio.security.security.SecurityConfig;
import dio.security.service.ClientUserService;

@RestController
public class LoginController {

	private final PasswordEncoder encoder;
	private final SecurityConfig securityConfig;
	private final ClientUserService service;

	public LoginController(PasswordEncoder encoder, SecurityConfig securityConfig, ClientUserService service) {
		this.encoder = encoder;
		this.securityConfig = securityConfig;
		this.service = service;
	}

	@PostMapping("/login")
	public Session logar(@RequestBody Login login) {
		var user = service.findByUsarName(login.getUsername());
		if (!Objects.isNull(user)) {
			boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
			if (!passwordOk) {
				throw new RuntimeException("Senha inválida p/ o login : " + login.getUsername());
			}
			Session session = new Session();
			session.setLogin(user.getUsername());

			JWTObject jwtObject = new JWTObject();
			jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
			jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
			jwtObject.setRoles(user.getRoles());
			session.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
			return session;
		} else {
			throw new RuntimeException("Erro ao tentar fazer login");
		}
	}
}
