package app.domain.ports.out;

import app.domain.model.HumanResourcesMember;
import app.domain.valueobject.Id;

import java.util.Optional;
import java.util.List;

public interface HumanResourcesRepository {
    void save(HumanResourcesMember member);
    void delete(Id id);
    Optional<HumanResourcesMember> findById(Id id);
    List<HumanResourcesMember> findAll();
}

