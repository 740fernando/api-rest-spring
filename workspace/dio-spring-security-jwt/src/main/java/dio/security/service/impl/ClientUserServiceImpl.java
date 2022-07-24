package dio.security.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;

import dio.security.model.ClientUser;
import dio.security.repository.ClientUserRepository;
import dio.security.service.ClientUserService;

public class ClientUserServiceImpl implements ClientUserService {

	private final ClientUserRepository repository;
	private final PasswordEncoder encoder;
	
	public ClientUserServiceImpl(ClientUserRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}

	@Override
	public void createUser(ClientUser request) {
		String pass = request.getPassword();
		request.setPassword(encoder.encode(pass));
		repository.save(request);
	}
}
