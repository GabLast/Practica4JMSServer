package edu.pucmm.eict;

import edu.pucmm.eict.JMS.Consumidor;
import edu.pucmm.eict.Services.MessageServices;
import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;

@SpringBootApplication
public class Practica4JmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Practica4JmsApplication.class, args);
    }

    @Autowired
    private MessageServices messageServices;

    @PostConstruct
    public void startConsumer() throws JMSException {
        new Consumidor(messageServices).conectar();
    }

}
