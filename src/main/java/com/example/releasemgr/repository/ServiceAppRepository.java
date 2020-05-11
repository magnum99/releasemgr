package com.example.releasemgr.repository;

import com.example.releasemgr.entity.ServiceApp;
import com.example.releasemgr.entity.ServiceAppPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceAppRepository extends CrudRepository<ServiceApp, ServiceAppPK>, RevisionRepository<ServiceApp, ServiceAppPK, Integer> {
}
