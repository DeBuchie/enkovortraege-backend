package de.inasys.enkovortraege.domain;

import lombok.Getter;

public class Title {
    @Getter
    private String value;

    public Title(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Titel darf nicht leer sein");
        }
        this.value = title;
    }
}
