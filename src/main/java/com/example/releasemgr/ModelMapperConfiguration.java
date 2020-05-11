package com.example.releasemgr;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        // Match properties exactly
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setCollectionsMergeEnabled(false);

        return mapper;
    }
}