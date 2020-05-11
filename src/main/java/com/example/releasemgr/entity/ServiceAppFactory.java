package com.example.releasemgr.entity;

import org.springframework.util.StringUtils;

public class ServiceAppFactory {
    public static ServiceApp create(String name, Long version) {
        if (StringUtils.isEmpty(name) || version == null) {
            throw new RuntimeException("name and version must be provided");
        }
        ServiceApp serviceApp = new ServiceApp();
        serviceApp.setVersion(version);
        serviceApp.setName(name);
        return serviceApp;
    }
}
