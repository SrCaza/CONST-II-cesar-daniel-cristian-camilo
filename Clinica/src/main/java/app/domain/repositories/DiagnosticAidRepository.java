package app.domain.repositories;

import app.domain.model.DiagnosticAid;
import app.domain.valueobject.Id;
import java.util.Optional;
import java.util.List;

public interface DiagnosticAidRepository {
    void save(DiagnosticAid diagnosticAid);
    Optional<DiagnosticAid> findById(Id id);
    void delete(Id id);
    List<DiagnosticAid> findAll();
}
