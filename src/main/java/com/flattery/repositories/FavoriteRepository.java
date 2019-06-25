package com.flattery.repositories;

import com.flattery.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {

    Stream<Favorite> findAllByUser_id(Integer User_id);
    Stream<Favorite> findAllByWohnung_id(Integer Wohnung_id);
}
