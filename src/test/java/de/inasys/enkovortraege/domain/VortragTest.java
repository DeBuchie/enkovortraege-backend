package de.inasys.enkovortraege.domain;

import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class VortragTest {

    @Test
    public void createVortragWithTitle() {
        assertThat(new Vortrag("Test Vortrag"))
            .isNotNull();
    }

    @Test
    public void createVortragWithValidIdAndTitle() {
        String vortragId = UUID.randomUUID().toString();
        assertThat(new Vortrag(vortragId, "Test Vortrag"))
            .isNotNull();
    }

    @Test
    public void creatingVortragWithInvalidIdThrowsError() {
        assertThatThrownBy(() -> new Vortrag("invalid id", "Test Vortag"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
