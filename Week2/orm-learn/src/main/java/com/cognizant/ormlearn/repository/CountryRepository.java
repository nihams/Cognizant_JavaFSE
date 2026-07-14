package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Derived query method - Spring Data JPA reads the method name and builds the SQL:
    // SELECT * FROM country WHERE co_name LIKE %partialName%
    // Used for "find list of countries matching a partial country name" (Hands on 5)
    List<Country> findByNameContaining(String partialName);
}
