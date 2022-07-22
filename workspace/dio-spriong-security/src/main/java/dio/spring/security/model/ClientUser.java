package dio.spring.security.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="tb_user")
public class ClientUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Integer id;

	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 20, nullable = false)
	private String username;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role_id")
	private List<String> roles = new ArrayList<>();
}
