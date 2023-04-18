package com.choker.claimcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

// ref.: https://dzone.com/articles/adding-entitymanagerrefresh-to-all-spring-data-rep
/* Purpose is to add EntityManager.refresh to All Spring Data Repositories
* so that entities can be retrieved from db after save operations,
* this is necessary when persisting an entity to DB then returning it to clients (typically in a POST method)*/
@NoRepositoryBean
public interface ClaimCenterRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    void refresh(T t);
}
