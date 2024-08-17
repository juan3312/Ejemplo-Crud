package com.ejemplo.crud.service;

import com.ejemplo.crud.model.Categoria;
import com.ejemplo.crud.repository.CategoriaRepository;

import java.util.List;


public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public List<Categoria> encontrarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria encontrarPorId(Long id) {
        return (Categoria) categoriaRepository.findById(id).orElse(null);
    }

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
