package com.ejemplo.crud.repository;

import com.ejemplo.crud.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends com.ejemplo.crud.repository.JpaRepository<Categoria, Long> {
    List<Categoria> findAll();

    Optional<Object> findById(Long id);

    Categoria save(Categoria categoria);

    default void deleteById(Long id) {

    }
}
