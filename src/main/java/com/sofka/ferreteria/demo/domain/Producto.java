package com.sofka.ferreteria.demo.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
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
