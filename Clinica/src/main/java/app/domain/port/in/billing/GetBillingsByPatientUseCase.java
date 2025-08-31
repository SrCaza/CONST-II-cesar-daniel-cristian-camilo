package app.domain.port.in.billing;

import app.domain.model.Billing;
import app.domain.valueobject.Id;
import java.util.List;

public interface GetBillingsByPatientUseCase {
    List<Billing> getByPatient(Id patientId);
}
