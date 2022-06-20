package com.sofka.ferreteria.demo.infra.dtos;


import com.sofka.ferreteria.demo.domain.Proveedor;
import com.sofka.ferreteria.demo.infra.data.ProductoAñadir;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ReciboDto {

    private String id;

    private ProductoAñadir productoAñadir;

    private String fechaIngreso;

    private Proveedor proveedor;
}
