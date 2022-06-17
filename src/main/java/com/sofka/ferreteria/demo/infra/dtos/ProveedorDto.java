package com.sofka.ferreteria.demo.infra.dtos;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document
@Builder(toBuilder = true)
public class ProveedorDto {

    private String id;
    private String fechaAsociacion;
    private String nombre;
    private String telefono;
    private String dni;
    private List<String> productosOfrecidos;
}

