package dio.security.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTObject {

	private String subject;
	private Date issuedAt;
	private Date expiration;
	private List<String> roles;
	
	public void setRoles(String... roles) {
		this.roles = Arrays.asList(roles);
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
