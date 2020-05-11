package com.example.releasemgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class ReleasemgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReleasemgrApplication.class, args);
    }

}
