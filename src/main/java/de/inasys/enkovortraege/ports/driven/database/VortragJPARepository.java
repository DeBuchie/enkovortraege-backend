package de.inasys.enkovortraege.ports.driven.database;

import de.inasys.enkovortraege.ports.driven.database.entity.DBVortrag;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VortragJPARepository extends CrudRepository<DBVortrag, String> {
}
