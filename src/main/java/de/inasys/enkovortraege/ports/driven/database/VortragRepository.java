package de.inasys.enkovortraege.ports.driven.database;

import de.inasys.enkovortraege.domain.Title;
import de.inasys.enkovortraege.domain.Vortrag;
import de.inasys.enkovortraege.domain.VortragId;
import de.inasys.enkovortraege.ports.driven.database.entity.DBVortrag;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class VortragRepository implements VortragRepositoryPort{

    private VortragJPARepository vortragJPARepository;

    @Autowired
    public VortragRepository(VortragJPARepository vortragJPARepository) {
        this.vortragJPARepository = vortragJPARepository;
    }

    @Override
    public List<Vortrag> loadAllVortraege() {
        Iterable<DBVortrag> dbVortraege = this.vortragJPARepository.findAll();
        return StreamSupport.stream(dbVortraege.spliterator(), false)
                .map(dbVortrag -> new Vortrag(new VortragId(dbVortrag.getId()), new Title(dbVortrag.getTitle()), dbVortrag.getBeschreibung()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Vortrag> getVortragById(VortragId vortragId) {
        return this.vortragJPARepository.findById(vortragId.getIdAsString())
                .map(dbVortrag -> new Vortrag(new VortragId(dbVortrag.getId()), new Title(dbVortrag.getTitle()), dbVortrag.getBeschreibung()));
    }

    @Override
    public void saveVortrag(Vortrag vortrag) {
        DBVortrag dbVortrag = DBVortrag.fromVortrag(vortrag);
        this.vortragJPARepository.save(dbVortrag);
    }
}
