package com.flattery.repositories;

import com.flattery.models.Wohnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface WohnungRepository extends CrudRepository<Wohnung, Integer> {

    Stream<Wohnung> findAllByName(String name);
}
