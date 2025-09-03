package app.domain.services;

import java.util.List;

import app.domain.model.HumanResources;
import app.domain.port.out.HumanResourcesRepository;

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
