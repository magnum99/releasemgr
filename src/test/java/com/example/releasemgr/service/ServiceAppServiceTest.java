package com.example.releasemgr.service;

import com.example.releasemgr.controller.dto.ServiceAppDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceAppServiceTest {
    @Autowired
    private ServiceAppService cut;

    @Test
    public void testDefaultScenario() {
        Assertions.assertEquals(1, deploy("ServiceA", 1L));
        Assertions.assertEquals(2, deploy("ServiceA", 2L));
        Assertions.assertEquals(3, deploy("ServiceB", 1L));
    }

    private Integer deploy(String name, Long version) {
        ServiceAppDTO dto = new ServiceAppDTO();
        dto.setName(name);
        dto.setVersion(version);

        return cut.deploy(dto);
    }

}