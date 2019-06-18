package com.flattery.config;

import com.flattery.services.IBarService;
import com.flattery.services.impl.BarSpringDataJpaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
public class PersistenceConfiguration {

    @Bean
    public IBarService barSpringDataJpaService() {
        return new BarSpringDataJpaService();
    }

}