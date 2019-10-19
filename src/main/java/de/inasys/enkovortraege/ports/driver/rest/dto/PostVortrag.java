package de.inasys.enkovortraege.ports.driver.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostVortrag {
    private String title;
    private String beschreibung;
}
