package dio.security.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Session {
	private String login;
	private String token;
}
