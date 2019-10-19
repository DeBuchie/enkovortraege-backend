package de.inasys.enkovortraege.ports.driven.database;

import de.inasys.enkovortraege.domain.Vortrag;
import de.inasys.enkovortraege.domain.VortragId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VortragRepositoryPort {
    List<Vortrag> loadAllVortraege();

    Optional<Vortrag> getVortragById(VortragId vortragId);

    void saveVortrag(Vortrag vortrag);
}
