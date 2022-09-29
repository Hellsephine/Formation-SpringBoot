package m2i.spring.examples.transactional;

import java.util.List;

public class TransactionalDto {

	List<TransactionalUser> users;
	
	List<TransactionalData> data;

	protected TransactionalDto()
	{
		
	}

	public TransactionalDto(List<TransactionalUser> users, List<TransactionalData> data) {
		this.users = users;
		this.data = data;
	}
	
	public List<TransactionalUser> getUsers() {
		return users;
	}

	public List<TransactionalData> getData() {
		return data;
	}
}
