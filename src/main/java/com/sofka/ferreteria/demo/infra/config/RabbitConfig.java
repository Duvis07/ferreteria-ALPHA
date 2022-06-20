package com.sofka.ferreteria.demo.infra.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    public final static String EXCHANGE = "ferreteria.exchange";

    public final static String CREAR_PRODUCTO_QUEUE = "action.crear.producto";
    public final static String AUMENTAR_PRODUCTO_QUEUE = "action.aumentar.producto";


    public final static String CREAR_PRODUCTO_ROUTINGKEY = "publish.product.create";
    public final static String AUMENTAR_PRODUCTO_ROUTINGKEY = "publish.receipt";


    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue getCrearProductoQueue(){
        return new Queue(CREAR_PRODUCTO_QUEUE);
    }

    @Bean
    public Queue getAumentarProductoQueue(){
        return new Queue(AUMENTAR_PRODUCTO_QUEUE);
    }

    @Bean Binding bindAumentarProducto(){
        return BindingBuilder.bind(getAumentarProductoQueue()).to(getTopicExchange()).with(AUMENTAR_PRODUCTO_ROUTINGKEY);
    }

    @Bean
    public Binding bindToCreateProduct(){
        return BindingBuilder.bind(getCrearProductoQueue()).to(getTopicExchange()).with(CREAR_PRODUCTO_ROUTINGKEY);
    }

}
