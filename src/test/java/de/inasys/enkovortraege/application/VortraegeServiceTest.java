package de.inasys.enkovortraege.application;

import de.inasys.enkovortraege.domain.Vortrag;
import de.inasys.enkovortraege.domain.VortragId;
import de.inasys.enkovortraege.ports.driven.database.VortragRepositoryPort;
import de.inasys.enkovortraege.ports.driver.rest.dto.PostVortrag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VortraegeServiceTest {
    @Mock
    private VortragRepositoryPort vortragRepository;

    @InjectMocks
    private AppVortraegeService appVortraegeService;

    private List<Vortrag> dummyVortraege;


    private static final String SEARCH_VORTRAG_ID = "a2100f9f-835d-4f1f-8655-31b6bf3802bd";
    private static final Vortrag DUMMY_VORTAG_1 = new Vortrag(
            SEARCH_VORTRAG_ID,
            "Vortrag 1");
    private static final Vortrag DUMMY_VORTAG_2 = new Vortrag(
            "417c8cb6-0b44-4290-bbdd-d7b920d67ea1",
            "Vortrag 2");
    private static final Vortrag DUMMY_VORTAG_3 = new Vortrag(
            "b9bef274-5d26-43f9-86b7-3c593a6269b1",
            "Vortrag 3");

    private static final PostVortrag POST_VORTRAG = new PostVortrag("Title", "Beschreibung");

    @Before
    public void createDumymVorteage() {
        dummyVortraege = Collections.unmodifiableList(new ArrayList<Vortrag>() {{
            add(DUMMY_VORTAG_1);
            add(DUMMY_VORTAG_2);
            add(DUMMY_VORTAG_3);
        }});
    }

    @Test
    public void getAllReturnsAllVortraege() {
        given(vortragRepository.loadAllVortraege()).willReturn(dummyVortraege);

        assertThat(appVortraegeService.getAllVortraege())
                .containsAll(dummyVortraege);
    }

    @Test
    public void findByIdOnlyReturnSearchItem() {
        VortragId vortragId = new VortragId(SEARCH_VORTRAG_ID);
        given(vortragRepository.getVortragById(vortragId)).willReturn(Optional.of(DUMMY_VORTAG_1));

        assertThat(appVortraegeService.getVortragById(vortragId))
                .get()
                .isSameAs(DUMMY_VORTAG_1);
    }

    @Test
    public void givenNonExistingIdShouldReturnEmptyOptional() {
        VortragId notExistingVortragId = new VortragId("e1a366bd-ff09-4564-b7a4-593003810328");
        given(vortragRepository.getVortragById(notExistingVortragId)).willReturn(Optional.empty());
        assertThat(appVortraegeService.getVortragById(notExistingVortragId))
                .isEmpty();
    }

    @Test
    public void saveVortrag() {
        appVortraegeService.createNewVortrag(POST_VORTRAG);
        verify(vortragRepository).saveVortrag(any(Vortrag.class));
    }


}
