package com.ejemplo.crud.repository;

import com.ejemplo.crud.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // No necesitas redefinir los métodos aquí, JpaRepository ya los proporciona.
}
