package m2i.spring.examples.transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransactionalUser {

	@GeneratedValue
	@Id
	private Integer id;
	
	@Column(unique=true)
	private String email;

	protected TransactionalUser() {
	}
	
	public TransactionalUser(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
}
