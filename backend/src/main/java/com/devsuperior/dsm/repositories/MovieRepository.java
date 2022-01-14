package com.devsuperior.dsm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsm.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>  {

}
