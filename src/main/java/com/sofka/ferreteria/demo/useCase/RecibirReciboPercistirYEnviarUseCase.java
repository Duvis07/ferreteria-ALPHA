package com.sofka.ferreteria.demo.useCase;

import com.google.gson.Gson;
import com.sofka.ferreteria.demo.infra.config.RabbitConfig;
import com.sofka.ferreteria.demo.infra.dtos.ReciboDto;
import com.sofka.ferreteria.demo.infra.mapper.ReciboMapper;
import com.sofka.ferreteria.demo.infra.repository.ReciboRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class RecibirReciboPercistirYEnviarUseCase implements Function<ReciboDto, Mono<ReciboDto>> {

    private final ReciboRepository repository;
    private final ReciboMapper mapper;
    private final RabbitTemplate template;
    private final Gson gson = new Gson();

    public RecibirReciboPercistirYEnviarUseCase(ReciboRepository repository, ReciboMapper mapper, RabbitTemplate template) {
        this.repository = repository;
        this.mapper = mapper;
        this.template = template;
    }


    @Override
    public Mono<ReciboDto> apply(ReciboDto reciboDto) {
        var reciboData = repository.save(mapper.deReciboDtoAData(reciboDto)).subscribe(recibo ->
            template
                    .convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.AUMENTAR_PRODUCTO_ROUTINGKEY, gson.toJson(recibo.getProductoAñadir()
                    )));
        return Mono.just(reciboDto);
    }
}
