package com.sofka.ferreteria.demo.infra.data;



import com.sofka.ferreteria.demo.domain.Proveedor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document
public class ReciboData {

    @Id
    private String id;

    private ProductoAñadir productoAñadir;

    private String fechaIngreso;

    private Proveedor proveedor;
}
