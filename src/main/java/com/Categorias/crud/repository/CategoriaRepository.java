package com.Categorias.crud.repository;

import com.Categorias.crud.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // No necesitas redefinir los métodos aquí, JpaRepository ya los proporciona.
}
