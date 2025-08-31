package app.domain.port.in.billing;

import app.domain.model.Billing;

public interface RegisterBillingUseCase {
    void register(Billing billing);
}
