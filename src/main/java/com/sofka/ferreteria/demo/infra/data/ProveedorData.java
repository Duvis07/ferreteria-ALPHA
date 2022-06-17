package com.sofka.ferreteria.demo.infra.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document
@Builder(toBuilder = true)
public class ProveedorData {

    @Id
    private String id;
    private String fechaAsociacion;
    private String nombre;
    private String telefono;
    private String dni;
    private List<String> productosOfrecidos;
}
