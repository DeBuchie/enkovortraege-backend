package de.inasys.enkovortraege.ports.driver.rest.dto;

import de.inasys.enkovortraege.domain.Vortrag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VortragVO {
    private String id;
    private String title;
    private String beschreibung;

    public static VortragVO fromVortrag(Vortrag vortrag) {
        VortragVO vortragVO = new VortragVO();
        vortragVO.setId(vortrag.getId().getIdAsString());
        vortragVO.setTitle(vortrag.getTitle().getValue());
        vortragVO.setBeschreibung(vortrag.getBeschreibung());
        return vortragVO;
    }
}
