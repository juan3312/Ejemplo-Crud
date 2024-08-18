package com.ejemplo.crud.service;

import com.ejemplo.crud.model.Categoria;
import com.ejemplo.crud.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> encontrarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria encontrarPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        } else {
            throw new RuntimeException("Categoría no encontrada con id: " + id);
        }
    }

    public Categoria guardar(Categoria categoria) {
        // Aquí podrías agregar validaciones antes de guardar
        return categoriaRepository.save(categoria);
    }

    public void eliminar(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Categoría no encontrada con id: " + id);
        }
    }
}
