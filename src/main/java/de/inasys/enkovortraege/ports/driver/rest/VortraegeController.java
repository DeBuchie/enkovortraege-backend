package de.inasys.enkovortraege.ports.driver.rest;

import de.inasys.enkovortraege.application.VortraegeService;
import de.inasys.enkovortraege.domain.Vortrag;
import de.inasys.enkovortraege.domain.VortragId;
import de.inasys.enkovortraege.ports.driver.rest.dto.PostVortrag;
import de.inasys.enkovortraege.ports.driver.rest.dto.VortragVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/vortraege")
public class VortraegeController {

    private VortraegeService vortraegeService;

    @Autowired
    public VortraegeController(VortraegeService vortraegeService) {
        this.vortraegeService = vortraegeService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity getAllVortraege() {
        List<Vortrag> vortraege = vortraegeService.getAllVortraege();
        return ResponseEntity.ok(
                vortraege.stream()
                .map(VortragVO::fromVortrag)
                .collect(Collectors.toList())
        );

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createNewVortrag(@RequestBody PostVortrag postVortrag) {
        Vortrag newVortrag = this.vortraegeService.createNewVortrag(postVortrag);
        try {
            URI uri = new URI("/vortraege/" + newVortrag.getId().getIdAsString());
            return ResponseEntity.created(uri).build();
        } catch (URISyntaxException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getVortragById(@PathVariable String id) {
        VortragId vortragId = new VortragId(id);
        return vortraegeService.getVortragById(vortragId)
                .map(VortragVO::fromVortrag)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
