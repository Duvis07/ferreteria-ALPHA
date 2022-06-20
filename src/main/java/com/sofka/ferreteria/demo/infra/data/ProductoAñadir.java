package com.sofka.ferreteria.demo.infra.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductoAñadir {

    private String idProducto;
    private String nombre;
    private int cantidad;
}
