package de.inasys.enkovortraege.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vortrag {
    private VortragId id;
    private Title title;
    private String beschreibung;

    public Vortrag(String title) {
        this.id = new VortragId();
        this.title = new Title(title);
    }

    public Vortrag(String id, String title) {
        this.id = new VortragId(id);
        this.title = new Title(title);
    }

}
