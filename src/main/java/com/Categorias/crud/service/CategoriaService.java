package com.Categorias.crud.service;

import com.Categorias.crud.model.Categoria;
import com.Categorias.crud.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

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
