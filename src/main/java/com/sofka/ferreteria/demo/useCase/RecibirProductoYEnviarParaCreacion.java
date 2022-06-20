package com.sofka.ferreteria.demo.useCase;


import com.google.gson.Gson;
import com.sofka.ferreteria.demo.infra.config.RabbitConfig;
import com.sofka.ferreteria.demo.infra.dtos.ProductoDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class RecibirProductoYEnviarParaCreacion implements Function<ProductoDto, Mono<ProductoDto>> {

    private final RabbitTemplate rabbitTemplate;

    private final Gson gson = new Gson();

    public RecibirProductoYEnviarParaCreacion(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Mono<ProductoDto> apply(ProductoDto productoDto) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.CREAR_PRODUCTO_ROUTINGKEY, gson.toJson(productoDto));
        return Mono.just(productoDto);
    }
}
