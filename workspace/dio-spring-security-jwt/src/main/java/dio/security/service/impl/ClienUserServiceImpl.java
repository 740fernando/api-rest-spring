package dio.security.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import dio.security.model.ClientUser;
import dio.security.repository.ClientUserRepository;
import dio.security.service.ClienUserService;

public class ClienUserServiceImpl implements ClienUserService {

	private final ClientUserRepository repository;
	private final PasswordEncoder encoder;
	
	public ClienUserServiceImpl(ClientUserRepository repository, PasswordEncoder encoder) {
		super();
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
