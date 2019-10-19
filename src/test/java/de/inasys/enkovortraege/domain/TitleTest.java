package de.inasys.enkovortraege.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TitleTest {

    @Test
    public void nullTitleThrowsException() {
        assertThatThrownBy(() -> new Title(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void emptyTitleThrowsException() {
        assertThatThrownBy(() -> new Title(""))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void createValidTitle() {
        assertThat(new Title("Test Title"))
                .isNotNull();
    }
}
