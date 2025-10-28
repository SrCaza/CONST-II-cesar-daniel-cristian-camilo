package app.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import app.domain.model.Billing;
import app.domain.repositories.BillingRepository;
import app.domain.valueobject.Id;

@Service
public class BillingAdapter implements BillingRepository{

	@Override
	public void save(Billing billing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Id id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Billing> findById(Id id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Billing> findByPatientId(Id patientId) {
		// TODO Auto-generated method stub
		return null;
	}

}
