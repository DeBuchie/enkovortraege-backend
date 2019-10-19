package de.inasys.enkovortraege.ports.driven.database.entity;

import de.inasys.enkovortraege.domain.Vortrag;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Vortraege")
public class DBVortrag {
    @Id
    @Column(length = 36)
    private String id;

    private String title;

    private String beschreibung;

    public static DBVortrag fromVortrag(Vortrag vortrag) {
        DBVortrag dbVortrag = new DBVortrag();
        dbVortrag.id = vortrag.getId().getIdAsString();
        dbVortrag.title = vortrag.getTitle().getValue();
        dbVortrag.beschreibung = vortrag.getBeschreibung();
        return dbVortrag;
    }
}
