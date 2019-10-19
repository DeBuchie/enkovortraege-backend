package de.inasys.enkovortraege.core.config;

import de.inasys.enkovortraege.ports.driven.database.VortragJPARepository;
import de.inasys.enkovortraege.ports.driven.database.VortragRepository;
import de.inasys.enkovortraege.ports.driven.database.VortragRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringPortsConfig {
    @Bean
    public VortragRepositoryPort vortragRepositoryPort(VortragJPARepository vortragJPARepository) {
        return new VortragRepository(vortragJPARepository);
    }
}
