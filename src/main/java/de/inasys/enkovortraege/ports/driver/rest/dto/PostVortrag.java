package de.inasys.enkovortraege.ports.driver.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostVortrag {
    private String title;
    private String beschreibung;
}
