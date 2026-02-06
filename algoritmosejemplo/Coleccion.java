package com.example.algoritmosejemplo;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Coleccion {

    private ArrayList<Instrumento> coleccion;

    public Coleccion() {
        coleccion = new ArrayList<>();
    }

    public ArrayList<Instrumento> getColeccion() {
        return coleccion;
    }

    public void agregarInstrumento(Instrumento i) {
        coleccion.add(i);
    }

    //Consultas

    public List<Instrumento> consultarPorAutor(String autor) {
        return coleccion.stream()
                .filter(i -> i.getAutor().equalsIgnoreCase(autor))
                .toList();
    }

    public List<Instrumento> consultarPorTipo(Instrumento.Tipo tipo) {
        return coleccion.stream()
                .filter(i -> i.getTipo() == tipo)
                .toList();
    }

    public List<Instrumento> consultarPorForma(Instrumento.Forma forma) {
        return coleccion.stream()
                .filter(i -> i.getForma() == forma)
                .toList();
    }

    public List<Instrumento> consultarPorCondicion(Instrumento.Condicion condicion) {
        return coleccion.stream()
                .filter(i -> i.getCondicion() == condicion)
                .toList();
    }

    public List<Instrumento> consultarPorValidez(boolean validez) {
        return coleccion.stream()
                .filter(i -> i.getValidez() == validez)
                .toList();
    }

    public List<Instrumento> ordenarPorClave() {
        return coleccion.stream()
                .sorted(Comparator.comparingInt(Instrumento::getClave))
                .toList();
    }

    public List<Instrumento> ordenarPorAutor() {
        return coleccion.stream()
                .sorted(Comparator.comparing(Instrumento::getAutor))
                .toList();
    }

    public boolean eliminarPorClave(int clave) {
        return coleccion.removeIf(i -> i.getClave() == clave);
    }

    /* ===== Guardar en archivo TXT ===== */
    public void guardarEnArchivoTxt(String rutaCarpeta, String nombreArchivo) {
        try {
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) carpeta.mkdirs(); // crea la carpeta si no existe

            File archivo = new File(carpeta, nombreArchivo + ".txt");
            try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                for (Instrumento i : coleccion) {
                    pw.println(
                            i.getClave() + "," +
                                    i.getNombre() + "," +
                                    i.getAutor() + "," +
                                    i.getTipo() + "," +
                                    i.getForma() + "," +
                                    i.getCondicion() + "," +
                                    i.getValidez() + "," +
                                    i.isConfiabilidad() + "," +
                                    i.getCita()
                    );
                }
            }
            System.out.println("¡Archivo guardado: " + archivo.getAbsolutePath() + "!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDesdeArchivoTxt(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists() || !carpeta.isDirectory()) {
            System.out.println("La carpeta no existe.");
            return;
        }

        File[] archivos = carpeta.listFiles((dir, nombre) -> nombre.endsWith(".txt"));
        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay archivos TXT en la carpeta.");
            return;
        }

        System.out.println("Archivos disponibles:");
        for (int i = 0; i < archivos.length; i++) {
            System.out.println((i + 1) + ". " + archivos[i].getName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Elige el número del archivo a cargar: ");
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion < 1 || opcion > archivos.length) {
            System.out.println("Opción inválida.");
            return;
        }

        File archivoSeleccionado = archivos[opcion - 1];
        coleccion.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                Instrumento i = new Instrumento();
                i.setClave(Integer.parseInt(datos[0]));
                i.setNombre(datos[1]);
                i.setAutor(datos[2]);
                i.setTipo(Instrumento.Tipo.valueOf(datos[3]));
                i.setForma(Instrumento.Forma.valueOf(datos[4]));
                i.setCondicion(Instrumento.Condicion.valueOf(datos[5]));
                i.setValidez(Boolean.parseBoolean(datos[6]));
                i.setConfiabilidad(Boolean.parseBoolean(datos[7]));
                i.setCita(Integer.parseInt(datos[8]));
                coleccion.add(i);
            }
            System.out.println("¡Archivo cargado correctamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
