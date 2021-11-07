package edu.pucmm.eict.JMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.pucmm.eict.Models.Message;
import edu.pucmm.eict.Services.MessageServices;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumidor {
    private MessageServices messageServices;
    private Topic topic;
    private MessageConsumer consumer;
    private Session session;
    private ActiveMQConnectionFactory factory;
    private Connection connection;

    public Consumidor(MessageServices messageServices) {
        this.messageServices = messageServices;
    }

    public void conectar() throws JMSException {
        //Creando el connection factory
        // indicando el host y puerto, en la trama el failover indica que reconecta de manera
        //automatica
        factory = new ActiveMQConnectionFactory("admin", "admin", "failover:tcp://" + messageServices.getUrl() + ":61616");

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
//                System.out.println("El mensaje de texto recibido: " + msg.getText()+ " - " +
//                        new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));

                //Transform json to POJO
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.registerModule(new JavaTimeModule());

                Message aux = objectMapper.readValue(msg.getText(), Message.class);
                Message toinsert = new Message(aux.getFechaGeneracion(), aux.getIdDispositivo(), aux.getTemperatura(), aux.getHumedad());
                messageServices.insert(toinsert);
            }catch(JMSException | JsonProcessingException ex){
//                ex.printStackTrace();
                System.out.println("ERROR: No se pudo recibir el mensaje");
            }
        });
    }

    public void cerrarConexion() throws JMSException {
        connection.stop();
        connection.close();
    }
}
