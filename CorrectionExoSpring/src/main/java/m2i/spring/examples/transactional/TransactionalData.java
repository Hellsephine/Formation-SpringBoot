package m2i.spring.examples.transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class TransactionalData {

	@GeneratedValue
	@Id
	private Integer id;
	
	@Column(unique=true)
	private int data;

	protected TransactionalData() {
	}
	
	public TransactionalData(int data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public int getData() {
		return data;
	}
}
