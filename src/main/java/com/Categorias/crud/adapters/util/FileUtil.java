package com.Categorias.crud.adapters.util;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

    public static void escribirEnArchivo(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void eliminarDeArchivo(String data, String filePath) {
        Path path = Paths.get(filePath);
        try {
            List<String> out;
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                out = reader.lines()
                        .filter(line -> !line.trim().equals(data))
                        .collect(Collectors.toList());
            }
            Files.write(path, out);
        } catch (IOException e) {
            System.err.println("Error al eliminar del archivo: " + e.getMessage());
        }
    }
}
