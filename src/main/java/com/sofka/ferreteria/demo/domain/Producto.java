package com.sofka.ferreteria.demo.domain;


import lombok.Data;

@Data
public class Producto {

    private String id;
    private String fechaCreacion;
    private String nombre;
    private String precio;
    private int unidadesDisponibles;
    private int maximoUnidades;
    private int minimoUnidades;
    private Proveedor proveedor;
}
