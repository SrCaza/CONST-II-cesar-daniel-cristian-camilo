package app.applicacion.usecase;

import java.util.List;

import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.HumanResources;
import app.domain.repositories.HumanResourcesRepository;
import app.domain.valueobject.Id;

@Service
public class HumanResourcesUseCase {
	
	@Autowired
	private HumanResourcesRepository humanResourcesRepository;

    //no esta es funcionamiento en ninguna implementacion
	public void createEmployee(HumanResourcesRepository createEmployee) {
		HumanResourcesRepository.save(createEmployee);
	}

	public void deleteEmployee(Id deleteEmployee) {
		
	}
	public List<HumanResources> updateEmployee(HumanResourcesRepository updateEmployee){
		return (List<HumanResources>) updateEmployee;
	}

}
