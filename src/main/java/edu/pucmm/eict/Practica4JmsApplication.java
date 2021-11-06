package edu.pucmm.eict;

import edu.pucmm.eict.JMS.Consumidor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.jms.JMSException;

@SpringBootApplication
public class Practica4JmsApplication {

    public static void main(String[] args) throws JMSException {
        SpringApplication.run(Practica4JmsApplication.class, args);
        new Consumidor().conectar();
    }

}
