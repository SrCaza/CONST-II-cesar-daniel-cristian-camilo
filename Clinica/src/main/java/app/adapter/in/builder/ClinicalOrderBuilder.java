package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.ClinicalOrderValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.Order;
import app.domain.model.User;

@Component
public class ClinicalOrderBuilder {
	
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private ClinicalOrderValidator clinicalOrderValidator;
	
	public Order builder(String document, String medicine,String doce) throws Exception {
		User doctor = new User();
		Order Order = new Order();
		doctor.setDocument(userValidator.documentValidator(document));
		Order.setDoctor(doctor);
		Order.setMedicine(clinicalOrderValidator.medicineValidator(medicine));
		Order.setDoce(clinicalOrderValidator.doceValidator(doce));
		return Order;
	}

}
