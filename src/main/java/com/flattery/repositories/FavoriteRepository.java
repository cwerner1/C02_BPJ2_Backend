package com.flattery.repositories;

import com.flattery.models.Favorite;
import com.flattery.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {

    //Stream<Favorite> findAllByUser_id(Integer User_id);
    //Stream<Favorite> findAllBywohnungID(Integer wohnungID);
    List<Favorite> findByUserIDAndWohnungID(Integer UserID, Integer WohnungID);
    List<Favorite> findByUserID(Integer UserID);
}
