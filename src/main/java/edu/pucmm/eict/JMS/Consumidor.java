package edu.pucmm.eict.JMS;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pucmm.eict.Models.Message;
import edu.pucmm.eict.Services.MessageServices;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consumidor {
    @Autowired
    private MessageServices messageServices;
    private Topic topic;
    private MessageConsumer consumer;
    private Session session;
    private ActiveMQConnectionFactory factory;
    private Connection connection;

    public void conectar() throws JMSException {
        //Creando el connection factory
        // indicando el host y puerto, en la trama el failover indica que reconecta de manera
        //automatica
        factory = new ActiveMQConnectionFactory("admin", "admin", "failover:tcp://localhost:61616");

        //Crea un nuevo hilo cuando hacemos a conexión, que no se detiene cuando
        // aplicamos el metodo stop(), para eso tenemos que cerrar la JVM o
        // realizar un close().
        connection = factory.createConnection();

        // Arrancamos la conexión
        //Puede verlo en direccion por defecto de tu activemq local:
        //http://127.0.0.1:8161/admin/connections.jsp
        connection.start();

        // Creando una sesión no transaccional y automatica.
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        topic = session.createTopic("notificacion_sensores");
        consumer = session.createConsumer(topic);

        consumer.setMessageListener(message -> {
            try {
                TextMessage msg = (TextMessage) message;
                System.out.println("El mensaje de texto recibido: " + msg.getText()+ " - " +
                        new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));

                //Transform msg to json
                ObjectMapper objectMapper = new ObjectMapper();
                Message mensajeRecibido = objectMapper.readValue(msg.getText(), Message.class);
                System.out.println(mensajeRecibido.toString());
            }catch(Exception ex){
                ex.printStackTrace();
            }
        });
    }

    public void cerrarConexion() throws JMSException {
        connection.stop();
        connection.close();
    }
}
