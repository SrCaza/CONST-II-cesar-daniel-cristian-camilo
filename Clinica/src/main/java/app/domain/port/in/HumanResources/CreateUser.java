package app.domain.port.in.HumanResources;

import java.util.List;

public class CreateUser {
	private final HumanResourcesRepository humanResourcesRepository;
	
	public CreateUser(HumanResourcesRepository humanResourcesRepository) {
		this.humanResourcesRepository = humanResourcesRepository;
	}
	public void createEmployee(HumanResourcesRepository createEmployee) {
		HumanResourcesRepository.save(createEmployee);
	}
}
