package dio.spring.security.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dio.spring.security.model.ClientUser;
import dio.spring.security.repository.UserRepository;

@Service
public class SecurityDataBaseService implements UserDetailsService {

	private final UserRepository userRepository;

	public SecurityDataBaseService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ClientUser userEntity = userRepository.findByUserName(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		userEntity.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		});
		UserDetails user = new User(userEntity.getUsername(), userEntity.getPassword(), authorities);
		return user;
	}
}
