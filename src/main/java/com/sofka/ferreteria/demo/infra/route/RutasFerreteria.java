package com.sofka.ferreteria.demo.infra.route;


import com.sofka.ferreteria.demo.infra.dtos.ProductoDto;
import com.sofka.ferreteria.demo.infra.dtos.ProveedorDto;
import com.sofka.ferreteria.demo.infra.dtos.ReciboDto;
import com.sofka.ferreteria.demo.useCase.CrearProveedorUseCase;
import com.sofka.ferreteria.demo.useCase.RecibirProductoYEnviarParaCreacion;
import com.sofka.ferreteria.demo.useCase.RecibirReciboPercistirYEnviarUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RutasFerreteria {


    @Bean
    public RouterFunction<ServerResponse> crearProveedorRuta(CrearProveedorUseCase crearProveedorUseCase){

        Function<ProveedorDto, Mono<ServerResponse>> executor =
                proveedorDto -> crearProveedorUseCase.apply(proveedorDto)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/crearProveedor")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProveedorDto.class).flatMap(executor));
    }

    @Bean
    public RouterFunction<ServerResponse> recibirProductoYEnviar(RecibirProductoYEnviarParaCreacion useCase){

        Function<ProductoDto, Mono<ServerResponse>> executor =
                productoDto -> useCase.apply(productoDto)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/recibirProducto")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductoDto.class).flatMap(executor));
    }

    @Bean
    public RouterFunction<ServerResponse> recibirReciboYEnviar(RecibirReciboPercistirYEnviarUseCase useCase){

        Function<ReciboDto, Mono<ServerResponse>> executor =
                reciboDto -> useCase.apply(reciboDto)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/recibirRecibo")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReciboDto.class).flatMap(executor));
    }
}
