package com.example.releasemgr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAppPK implements Serializable {
    private Long version;
    private String name;
}
