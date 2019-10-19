package de.inasys.enkovortraege.domain;

import org.junit.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VortragIdTest {

    @Test
    public void nonUUIDStringForConstructor() {
        assertThatThrownBy(() -> new VortragId("test"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validUUIDStringForConstructor() {
        String validUUID = UUID.randomUUID().toString();

        assertThat(new VortragId(validUUID))
                .extracting(VortragId::getIdAsString)
                .isEqualTo(validUUID);

    }
}
