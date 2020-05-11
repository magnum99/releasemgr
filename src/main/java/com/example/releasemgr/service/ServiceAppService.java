package com.example.releasemgr.service;

import com.example.releasemgr.controller.dto.ServiceAppDTO;
import com.example.releasemgr.entity.ServiceApp;
import com.example.releasemgr.entity.ServiceAppFactory;
import com.example.releasemgr.entity.SystemVersion;
import com.example.releasemgr.repository.SystemVersionAuditRepository;
import com.example.releasemgr.repository.SystemVersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ServiceAppService {
    private final SystemVersionAuditRepository systemVersionAuditRepository;
    private final SystemVersionRepository systemVersionRepository;

    public Integer deploy(ServiceAppDTO dto) {
        SystemVersion systemVersion = systemVersionRepository.findById(SystemVersion.ID)
                .orElseGet(() -> systemVersionRepository.save(new SystemVersion()));

        ServiceApp serviceApp = ServiceAppFactory.create(dto.getName(), dto.getVersion());
        serviceApp.setSystemVersion(systemVersion);
        // replace service app if it differs from object in the list
        replaceIfDifferentObject(systemVersion, serviceApp);

        return systemVersionRepository.save(systemVersion).getVersion();
    }

    private void replaceIfDifferentObject(SystemVersion systemVersion, ServiceApp serviceApp) {
        systemVersion.getServiceApps().removeIf(sa -> sa.getName().equals(serviceApp.getName()) && !sa.getVersion().equals(serviceApp.getVersion()));
        systemVersion.getServiceApps().add(serviceApp);
    }

    public Set<ServiceApp> servicesForSystemVersion(int systemVersion) {
        Optional<SystemVersion> systemVersionSnapshot = systemVersionAuditRepository.findSystemVersionServices(systemVersion);
        if (systemVersionSnapshot.isEmpty()) {
            return Collections.emptySet();
        }

        return systemVersionSnapshot.get().getServiceApps();
    }
}
