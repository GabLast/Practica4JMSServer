package edu.pucmm.eict;

import edu.pucmm.eict.JMS.Consumidor;
import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;

@SpringBootApplication
public class Practica4JmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Practica4JmsApplication.class, args);
    }

    @PostConstruct
    public void startConsumer() throws JMSException {
        new Consumidor().conectar();
    }

}
