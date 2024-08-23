package com.Categorias.crud.adapters.service;
import com.Categorias.crud.model.Categoria;
import com.Categorias.crud.adapters.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    private final com.Categorias.crud.adapters.repository.CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(com.Categorias.crud.adapters.repository.CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> encontrarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria encontrarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
    }

    @Transactional
    public Categoria guardar(Categoria categoria) {
        // Verificar si ya existe una categoría con el mismo nombre
        if (categoriaRepository.existsByNombre(categoria.getNombre())) {
            throw new RuntimeException("Ya existe una categoría con el nombre: " + categoria.getNombre());
        }
        // Guardar la nueva categoría si no existe
        Categoria savedCategoria = categoriaRepository.save(categoria);
        String data = String.format("INSERT INTO categoria (nombre, descripcion) VALUES ('%s', '%s');",
                savedCategoria.getNombre(), savedCategoria.getDescripcion());
        FileUtil.escribirEnArchivo(data, "src/main/resources/data.sql");
        return savedCategoria;
    }

    @Transactional
    public void eliminar(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
        categoriaRepository.deleteById(id);
        String data = String.format("INSERT INTO categoria (nombre, descripcion) VALUES ('%s', '%s');",
                categoria.getNombre(), categoria.getDescripcion());
        FileUtil.eliminarDeArchivo(data, "src/main/resources/data.sql");
    }
}
