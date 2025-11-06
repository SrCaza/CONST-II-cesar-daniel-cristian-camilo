package app.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.Billing;
import app.domain.repositories.BillingRepository;
import app.domain.valueobject.Id;

@Service
public class BillingUseCase {
	
	@Autowired
	private BillingRepository billingRepository;
	
    public List<Billing> GetBillingsByPatientUseCase(Id billingpatientId) {
		return (List<Billing>)billingpatientId;
	}
    public void register(Billing billing) {
	}

}
