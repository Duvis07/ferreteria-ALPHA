package com.sofka.ferreteria.demo.infra.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductoAñadir {

    private String idProducto;
    private String nombre;
    private int cantidad;
}
