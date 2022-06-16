package com.sofka.ferreteria.demo.infra.dtos;

import com.sofka.ferreteria.demo.domain.Proveedor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductoDto {

    private final String id;
    private final String fechaCreacion;
    private final String nombre;
    private final String precio;
    private final int unidadesDisponibles;
    private final int maximoUnidades;
    private final int minimoUnidades;
    private final Proveedor proveedor;
}
