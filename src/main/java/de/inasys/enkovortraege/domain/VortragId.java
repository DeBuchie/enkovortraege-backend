package de.inasys.enkovortraege.domain;

import lombok.Getter;

import java.util.UUID;


public class VortragId {
    @Getter
    private UUID uuid;

    public VortragId() {
        this.uuid = UUID.randomUUID();
    }

    public VortragId(String vortragId) {
        this.uuid = UUID.fromString(vortragId);
    }

    public VortragId(UUID vortragId) {
        this.uuid = vortragId;
    }

    public String getIdAsString() {
        return this.uuid.toString();
    }

}
