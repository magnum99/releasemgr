package com.example.releasemgr.controller;

import com.example.releasemgr.controller.dto.ServiceAppDTO;
import com.example.releasemgr.entity.ServiceApp;
import com.example.releasemgr.service.ServiceAppService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ServiceAppController {

    private final ServiceAppService serviceAppService;
    private final ModelMapper mapper;

    @PostMapping("/deploy")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Integer> deployService(@Valid @RequestBody ServiceAppDTO dto) {
        return ResponseEntity.ok(serviceAppService.deploy(dto));
    }

    @GetMapping("/services")
    public ResponseEntity<Set<ServiceAppDTO>> servicesForSystemVersion(@NotEmpty @RequestParam("systemVersion") int systemVersion) {
        Set<ServiceApp> serviceApps = serviceAppService.servicesForSystemVersion(systemVersion);
        return ResponseEntity.ok(serviceApps.stream().map(sa -> mapper.map(sa, ServiceAppDTO.class)).collect(Collectors.toSet()));
    }
}
