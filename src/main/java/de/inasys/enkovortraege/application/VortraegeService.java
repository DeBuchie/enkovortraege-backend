package de.inasys.enkovortraege.application;

import de.inasys.enkovortraege.domain.Vortrag;
import de.inasys.enkovortraege.domain.VortragId;
import de.inasys.enkovortraege.ports.driver.rest.dto.PostVortrag;

import java.util.List;
import java.util.Optional;

public interface VortraegeService {
    List<Vortrag> getAllVortraege();

    Optional<Vortrag> getVortragById(VortragId vortragId);

    Vortrag createNewVortrag(PostVortrag postVortrag);

}
