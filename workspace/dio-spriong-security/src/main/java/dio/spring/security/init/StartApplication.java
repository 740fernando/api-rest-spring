package dio.spring.security.init;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dio.spring.security.model.ClientUser;
import dio.spring.security.repository.UserRepository;

@Component
public class StartApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		ClientUser user = userRepository.findByUserName("admin");
		if(user==null) {
			user = new ClientUser();
			user.setName("ADMIN");
			user.setUsername("admin");
			user.setPassword("master123");
			user.getRoles().add("MANAGERS");
			userRepository.save(user);
		}
		user = userRepository.findByUserName("users");
		if(user == null) {
			user = new ClientUser();
			user.setName("USER");
			user.setUsername("user");
			user.setPassword("user123");
			user.getRoles().add("USERS");
			userRepository.save(user);
		}
	}

}
