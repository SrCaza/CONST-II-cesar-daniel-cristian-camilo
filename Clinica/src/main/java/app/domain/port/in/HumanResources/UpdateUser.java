package app.domain.port.in.HumanResources;

import java.util.List;

public class UpdateUser {
	
	private final HumanResourcesRepository humanResourcesRepository;

	public UpdateUser(HumanResourcesRepository humanResourcesRepository) {
		this.humanResourcesRepository = humanResourcesRepository;
	}
	public List<HumanResources> updateEmployee(HumanResourcesRepository updateEmployee){
		return (List<HumanResources>) updateEmployee;
	}

}
