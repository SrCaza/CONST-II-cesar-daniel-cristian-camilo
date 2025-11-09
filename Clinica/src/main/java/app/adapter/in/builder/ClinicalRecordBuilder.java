package app.adapter.in.builder;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.ClinicalOrderValidator;
import app.adapter.in.validators.ClinicalRecordValidators;
import app.adapter.in.validators.UserValidator;
import app.domain.model.MedicalRecord;
import app.domain.model.Order;
import app.domain.model.User;

@Component
public class ClinicalRecordBuilder {
	
	@Autowired
	private ClinicalRecordValidators clinicalRecordValidators;
	@Autowired
	private UserValidator uservalidator;
	@Autowired
	private ClinicalOrderValidator clinialOrderValidator;
	
	
	public MedicalRecord create(String document, boolean stat)throws Exception{
		MedicalRecord MedicalRecord = new MedicalRecord();
		User doctor = new User();
		Order order = new Order();
		User user = new User();
		doctor.setDocument(uservalidator.documentValidator(document));
		user.setId(uservalidator.documentValidator(document));
		order.setId(clinialOrderValidator.idValidator(document));
		MedicalRecord.setDoctor(doctor);
		MedicalRecord.setOrder(order);
		MedicalRecord.setDate(new Date(System.currentTimeMillis()));
		MedicalRecord.setStat(true);
		return MedicalRecord;
	}

}
