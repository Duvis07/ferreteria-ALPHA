package com.sofka.ferreteria.demo.domain;

import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class Proveedor {

    private String id;
    private String fechaAsociacion;
    private String nombre;
    private String telefono;
    private String dni;
    private List<String> productosOfrecidos;

    public Proveedor afectarProveedorDesdeDominio(){
        this.fechaAsociacion = this.fechaAsociacion.concat(" afectado desde el dominio");
        this.nombre = this.nombre.concat(" afectado desde el dominio");
        this.telefono = this.telefono.concat(" afectado desde el dominio");
        this.dni = this.dni.concat("afectado desde el dominio");
        return this;
    }
}
