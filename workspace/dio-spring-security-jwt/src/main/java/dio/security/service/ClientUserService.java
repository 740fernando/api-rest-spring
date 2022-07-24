package dio.security.service;

import dio.security.model.ClientUser;

public interface ClientUserService {

	void createUser(ClientUser request);
	ClientUser findByUsarName(String request);
}
