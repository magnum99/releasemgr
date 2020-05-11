package com.example.releasemgr.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ServiceAppDTO implements Serializable {
    @NotEmpty
    private String name;
    @NotNull
    private Long version;
}
