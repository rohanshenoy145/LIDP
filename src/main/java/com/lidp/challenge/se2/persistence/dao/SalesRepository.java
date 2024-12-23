package com.lidp.challenge.se2.persistence.dao;

import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<SalesEntity, Integer> {
}