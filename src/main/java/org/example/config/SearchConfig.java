package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@Slf4j
public class SearchConfig {
//    @Bean
//    public EntityManager entityManager() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
//        return factory.createEntityManager();
//    }
}
