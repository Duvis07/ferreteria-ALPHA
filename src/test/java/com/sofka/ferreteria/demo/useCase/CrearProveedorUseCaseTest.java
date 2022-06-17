package com.sofka.ferreteria.demo.useCase;

import com.sofka.ferreteria.demo.infra.data.ProveedorData;
import com.sofka.ferreteria.demo.infra.dtos.ProveedorDto;
import com.sofka.ferreteria.demo.infra.mapper.ProveedorMapper;
import com.sofka.ferreteria.demo.infra.repository.ProveedorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class CrearProveedorUseCaseTest {


    @Mock
    private ProveedorRepository repository;

    private ProveedorMapper mapper = new ProveedorMapper();

    CrearProveedorUseCase useCase;

    @BeforeEach
    public void setUp(){
        useCase = new CrearProveedorUseCase(repository, mapper);
    }

    @Test
    public void crearProveedor(){
        var proveedorDto = ProveedorDto.builder()
                .dni("1321234123")
                .fechaAsociacion("Mayo 30 2022")
                .nombre("prueba")
                .telefono("3205148798")
                .productosOfrecidos(List.of("primera", "lista"))
                .build();

        var proveedorData = ProveedorData.builder()
                .id("asd767as98afa98df")
                .dni("1321234123")
                .fechaAsociacion("Mayo 30 2022")
                .nombre("prueba")
                .telefono("3205148798")
                .productosOfrecidos(List.of("primera", "lista"))
                .build();

        Mockito.when(repository.save(Mockito.any(ProveedorData.class))).thenReturn(Mono.just(proveedorData));

        var publisher = useCase.apply(proveedorDto);

        StepVerifier.create(publisher)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(repository).save(Mockito.any(ProveedorData.class));
    }
}