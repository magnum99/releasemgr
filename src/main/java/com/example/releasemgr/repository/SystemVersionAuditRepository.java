package com.example.releasemgr.repository;

import com.example.releasemgr.entity.SystemVersion;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class SystemVersionAuditRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Optional<SystemVersion> findSystemVersionServices(int version) {
        try {
            AuditReader auditReader = AuditReaderFactory.get(entityManager);

            AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(SystemVersion.class, true, false)
                    .add(AuditEntity.id().eq(SystemVersion.ID))
                    .add(AuditEntity.property("version").eq(version));

            return Optional.of((SystemVersion) auditQuery.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

}
