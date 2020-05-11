package com.example.releasemgr.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Audited
@EqualsAndHashCode
public class SystemVersion {
    public static final String ID = "SYSTEM_VERSION";
    @Id
    private String id = SystemVersion.ID;

    @Version
    private int version;

    @Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ServiceApp> serviceApps = new HashSet<>();
}
