package app.domain.port.in.ImformationSupport;

import app.domain.valueobject.Id;
import java.util.List;
import java.util.Optional;

public interface InformationSupportRepository {
    void save(InformationSupport infoSupport);
    Optional<InformationSupport> findById(Id id);
    void delete(Id id);
    List<InformationSupport> findAll();
}
