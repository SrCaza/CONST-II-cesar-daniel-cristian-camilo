package app.domain.port.in.Invoce;

import app.domain.valueobject.Id;
import java.util.Optional;

public interface InvoiceRepository {
    void save(Invoice invoice);
    Optional<Invoice> findById(Id invoiceId);
}

