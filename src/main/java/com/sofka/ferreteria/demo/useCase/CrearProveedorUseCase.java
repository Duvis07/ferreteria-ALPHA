package com.sofka.ferreteria.demo.useCase;

import com.sofka.ferreteria.demo.infra.dtos.ProveedorDto;
import com.sofka.ferreteria.demo.infra.mapper.ProveedorMapper;
import com.sofka.ferreteria.demo.infra.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class CrearProveedorUseCase implements Function<ProveedorDto, Mono<ProveedorDto>> {

    private final ProveedorRepository repository;
    private final ProveedorMapper mapper;

    public CrearProveedorUseCase(ProveedorRepository repository, ProveedorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public Mono<ProveedorDto> apply(ProveedorDto proveedorDto) {
        var proveedor = mapper.deDtoParaModeloProveedor(proveedorDto);
        var proveedorData = mapper.deModeloADataProveedor(proveedor.afectarProveedorDesdeDominio());
        return repository.save(proveedorData).map(proveedorData1 -> mapper.deDataParaDtoProveedor(proveedorData1));
    }
}
