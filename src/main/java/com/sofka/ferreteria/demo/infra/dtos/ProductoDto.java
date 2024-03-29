package com.sofka.ferreteria.demo.infra.dtos;

import com.sofka.ferreteria.demo.domain.Proveedor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductoDto {

    private String id;
    private String fechaCreacion;
    private String nombre;
    private double precio;
    private int unidadesDisponibles = 0;
    private int maximoUnidades;
    private int minimoUnidades;
    private Proveedor proveedor;
}
