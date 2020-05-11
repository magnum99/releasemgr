package com.example.releasemgr.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(ServiceAppPK.class)
@Data
@Audited
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ServiceApp {
    @Id
    private Long version;
    @Id
    @EqualsAndHashCode.Include
    private String name;

    @Audited(targetAuditMode = RelationTargetAuditMode.AUDITED)
    @ManyToOne(cascade = {CascadeType.ALL}, optional = false, fetch = FetchType.EAGER)
    @NotNull
    @ToString.Exclude
    private SystemVersion systemVersion;

    @Transient
    public ServiceAppPK getCompositeKey() {
        return new ServiceAppPK(version, name);
    }
}
