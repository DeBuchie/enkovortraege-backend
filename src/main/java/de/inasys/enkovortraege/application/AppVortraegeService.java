package de.inasys.enkovortraege.application;

import de.inasys.enkovortraege.domain.Vortrag;
import de.inasys.enkovortraege.domain.VortragId;
import de.inasys.enkovortraege.ports.driven.database.VortragRepositoryPort;
import de.inasys.enkovortraege.ports.driver.rest.dto.PostVortrag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppVortraegeService implements VortraegeService{

    private VortragRepositoryPort vortragRepository;

    public AppVortraegeService(VortragRepositoryPort vortragRepository) {
        this.vortragRepository = vortragRepository;
    }

    @Override
    public List<Vortrag> getAllVortraege() {
        return vortragRepository.loadAllVortraege();
    }

    @Override
    public Optional<Vortrag> getVortragById(VortragId vortragId) {
        return vortragRepository.getVortragById(vortragId);
    }

    @Override
    public Vortrag createNewVortrag(PostVortrag postVortrag) {
        Vortrag vortrag = new Vortrag(postVortrag.getTitle());
        String beschreibung = postVortrag.getBeschreibung();
        if (beschreibung != null && !beschreibung.isEmpty()) {
            vortrag.setBeschreibung(beschreibung);
        }
        vortragRepository.saveVortrag(vortrag);
        return vortrag;
    }
}
