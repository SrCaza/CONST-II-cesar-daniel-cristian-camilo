package app.domain.port.in.HumanResources;

import java.util.List;

public class HumanResourcesService {
	private final HumanResourcesRepository humanResourcesRepository;
	
	public HumanResourcesService(HumanResourcesRepository humanResourcesRepository) {
		this.humanResourcesRepository = humanResourcesRepository;
	}
	public void createEmployee(HumanResourcesRepository createEmployee) {
		HumanResourcesRepository.save(createEmployee);
	}
	public List<HumanResources> updateEmployee(HumanResourcesRepository updateEmployee){
		return (List<HumanResources>) updateEmployee;
	}
	public void deleteEmployee(HumanResources deleteEmployee) {
		
	}

}
