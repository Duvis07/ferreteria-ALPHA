package com.sofka.ferreteria.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Proveedor {

    private String id;
    private String fechaAsociacion;
    private String nombre;
    private String telefono;
    private String dni;
    private List<String> productosOfrecidos;
}
