package com.flattery.repositories;

import com.flattery.models.Wohnung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface WohnungRepository extends CrudRepository<Wohnung, Integer> {

    Stream<Wohnung> findAllByDescription(String description);
    List<Wohnung> findAllByCity(String city);

}
