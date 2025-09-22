package app.domain.repositories;

import app.domain.model.Procedure;
import app.domain.valueobject.Id;
import java.util.Optional;
import java.util.List;

public interface ProcedureRepository {
    void save(Procedure procedure);
    Optional<Procedure> findById(Id id);
    void delete(Id id);
    List<Procedure> findAll();
}
