package com.example.algoritmosejemplo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coleccion coleccion = new Coleccion();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n----- MENÚ ------");
            System.out.println("1. Agregar instrumento");
            System.out.println("2. Consultar por autor");
            System.out.println("3. Consultar por tipo");
            System.out.println("4. Consultar por forma");
            System.out.println("5. Consultar por condición");
            System.out.println("6. Consultar por validez");
            System.out.println("7. Ordenar por clave");
            System.out.println("8. Ordenar por autor");
            System.out.println("9. Eliminar por clave");
            System.out.println("10. Guardar en archivo");
            System.out.println("11. Cargar desde archivo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    Instrumento i = new Instrumento();
                    System.out.print("Nombre: ");
                    i.setNombre(sc.nextLine());
                    System.out.print("Autor: ");
                    i.setAutor(sc.nextLine());

                    System.out.print("Tipo (IDENTIFICAR/MANEJAR): ");
                    i.setTipo(Instrumento.Tipo.valueOf(sc.nextLine().toUpperCase()));

                    System.out.print("Forma (ESCALA/CUESTIONARIO/TEST): ");
                    i.setForma(Instrumento.Forma.valueOf(sc.nextLine().toUpperCase()));

                    System.out.print("Condición (ESTRES/ANSIEDAD/AMBOS): ");
                    i.setCondicion(Instrumento.Condicion.valueOf(sc.nextLine().toUpperCase()));

                    System.out.print("Validez (true/false): ");
                    i.setValidez(Boolean.parseBoolean(sc.nextLine()));

                    System.out.print("Confiabilidad (true/false): ");
                    i.setConfiabilidad(Boolean.parseBoolean(sc.nextLine()));

                    System.out.print("Clave: ");
                    i.setClave(Integer.parseInt(sc.nextLine()));

                    System.out.print("Cita: ");
                    i.setCita(Integer.parseInt(sc.nextLine()));

                    coleccion.agregarInstrumento(i);
                    System.out.println("¡Instrumento agregado!");
                    break;

                case 2:
                    System.out.print("Introduce autor: ");
                    String autor = sc.nextLine();
                    List<Instrumento> listaAutor = coleccion.consultarPorAutor(autor);
                    listaAutor.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Introduce tipo (IDENTIFICAR/MANEJAR): ");
                    Instrumento.Tipo tipo = Instrumento.Tipo.valueOf(sc.nextLine().toUpperCase());
                    List<Instrumento> listaTipo = coleccion.consultarPorTipo(tipo);
                    listaTipo.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Introduce forma (ESCALA/CUESTIONARIO/TEST): ");
                    Instrumento.Forma forma = Instrumento.Forma.valueOf(sc.nextLine().toUpperCase());
                    List<Instrumento> listaForma = coleccion.consultarPorForma(forma);
                    listaForma.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Introduce condición (ESTRES/ANSIEDAD/AMBOS): ");
                    Instrumento.Condicion condicion = Instrumento.Condicion.valueOf(sc.nextLine().toUpperCase());
                    List<Instrumento> listaCondicion = coleccion.consultarPorCondicion(condicion);
                    listaCondicion.forEach(System.out::println);
                    break;

                case 6:
                    System.out.print("Introduce validez (true/false): ");
                    boolean validez = Boolean.parseBoolean(sc.nextLine());
                    List<Instrumento> listaValidez = coleccion.consultarPorValidez(validez);
                    listaValidez.forEach(System.out::println);
                    break;

                case 7:
                    List<Instrumento> ordenClave = coleccion.ordenarPorClave();
                    ordenClave.forEach(System.out::println);
                    break;

                case 8:
                    List<Instrumento> ordenAutor = coleccion.ordenarPorAutor();
                    ordenAutor.forEach(System.out::println);
                    break;

                case 9:
                    System.out.print("Introduce clave a eliminar: ");
                    int clave = Integer.parseInt(sc.nextLine());
                    boolean eliminado = coleccion.eliminarPorClave(clave);
                    System.out.println(eliminado ? "¡Instrumento eliminado!" : "No se encontró clave.");
                    break;

                case 10:
                    coleccion.guardarEnArchivoTxt("algoritmosejemplo", "misInstrumentos");
                    break;

                case 11:
                    coleccion.cargarDesdeArchivoTxt("algoritmosejemplo");
                    break;

                case 0:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }
}

