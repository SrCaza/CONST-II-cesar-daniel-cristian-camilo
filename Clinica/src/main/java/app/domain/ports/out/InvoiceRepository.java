package app.domain.ports.out;

import app.domain.model.Invoice;
import app.domain.valueobject.Id;
import java.util.Optional;

public interface InvoiceRepository {
    void save(Invoice invoice);
    Optional<Invoice> findById(Id invoiceId);
}

