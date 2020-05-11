package com.example.releasemgr.repository;

import com.example.releasemgr.entity.SystemVersion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemVersionRepository extends CrudRepository<SystemVersion, String>, RevisionRepository<SystemVersion, String, Integer> {

}
