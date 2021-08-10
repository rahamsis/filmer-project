package com.filmer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmer.entities.Actor;
import com.filmer.entities.Pelicula;

@Repository
public interface IPeliculasDAO extends JpaRepository<Pelicula, Long> {

}
