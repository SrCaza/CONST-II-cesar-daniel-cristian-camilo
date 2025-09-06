package app.domain.port.in.HumanResources;

import app.domain.valueobject.Id;

import java.util.Optional;
import java.util.List;

public interface HumanResourcesRepository {
    void save(HumanResources member);
    void delete(Id id);
    Optional<HumanResources> findById(Id id);
    List<HumanResources> findAll();
	Optional<HumanResources> findById(Long hrId);
	static void save(HumanResourcesRepository createEmployee) {}
}

