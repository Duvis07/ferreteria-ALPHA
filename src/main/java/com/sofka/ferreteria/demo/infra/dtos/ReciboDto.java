package com.sofka.ferreteria.demo.infra.dtos;


import com.sofka.ferreteria.demo.domain.Proveedor;
import com.sofka.ferreteria.demo.infra.data.ProductoAñadir;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ReciboDto {

    private String id;

    private ProductoAñadir productoAñadir;

    private String fechaIngreso = LocalDate.now().toString();

    private Proveedor proveedor;
}
