package com.flattery.repositories;

import com.flattery.domain.Bar;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface IBarCrudRepository extends CrudRepository<Bar, Serializable> {
    //
}
