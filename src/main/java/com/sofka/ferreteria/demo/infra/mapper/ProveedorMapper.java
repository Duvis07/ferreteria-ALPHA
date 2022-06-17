package com.sofka.ferreteria.demo.infra.mapper;

import com.sofka.ferreteria.demo.domain.Proveedor;
import com.sofka.ferreteria.demo.infra.data.ProveedorData;
import com.sofka.ferreteria.demo.infra.dtos.ProveedorDto;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {


    public ProveedorDto deModeloADtoProveedor(Proveedor proveedor){
        var retorno = new ProveedorDto(
                proveedor.getId(),
                proveedor.getFechaAsociacion(),
                proveedor.getNombre(),
                proveedor.getTelefono(),
                proveedor.getDni(),
                proveedor.getProductosOfrecidos()
        );
        return retorno;
    }

    public Proveedor deDtoParaModeloProveedor(ProveedorDto proveedorDto){
        var retorno = new Proveedor(
                proveedorDto.getId(),
                proveedorDto.getFechaAsociacion(),
                proveedorDto.getNombre(),
                proveedorDto.getTelefono(),
                proveedorDto.getDni(),
                proveedorDto.getProductosOfrecidos()
        );
        return retorno;
    }

    public ProveedorData deDtoParaDataProveedor(ProveedorDto proveedorDto){
        var retorno = new ProveedorData(
                proveedorDto.getId(),
                proveedorDto.getFechaAsociacion(),
                proveedorDto.getNombre(),
                proveedorDto.getTelefono(),
                proveedorDto.getDni(),
                proveedorDto.getProductosOfrecidos()
        );
        return retorno;
    }

    public Proveedor deDataParaModeloProveedor(ProveedorData proveedorData){
        var retorno = new Proveedor(
                proveedorData.getId(),
                proveedorData.getFechaAsociacion(),
                proveedorData.getNombre(),
                proveedorData.getTelefono(),
                proveedorData.getDni(),
                proveedorData.getProductosOfrecidos()
        );
        return retorno;
    }

    public ProveedorDto deDataParaDtoProveedor(ProveedorData proveedorData){
        var retorno = new ProveedorDto(
                proveedorData.getId(),
                proveedorData.getFechaAsociacion(),
                proveedorData.getNombre(),
                proveedorData.getTelefono(),
                proveedorData.getDni(),
                proveedorData.getProductosOfrecidos()
        );
        return retorno;
    }

    public ProveedorData deModeloADataProveedor(Proveedor proveedor){
        var retorno = new ProveedorData(
                proveedor.getId(),
                proveedor.getFechaAsociacion(),
                proveedor.getNombre(),
                proveedor.getTelefono(),
                proveedor.getDni(),
                proveedor.getProductosOfrecidos()
        );
        return retorno;
    }
}
