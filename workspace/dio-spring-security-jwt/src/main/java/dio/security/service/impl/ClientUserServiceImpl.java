package dio.security.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dio.security.model.ClientUser;
import dio.security.repository.ClientUserRepository;
import dio.security.service.ClientUserService;

@Service
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

	@Override
	public ClientUser findByUsarName(String request) {
		return repository.findByUserName(request);
	}
}
