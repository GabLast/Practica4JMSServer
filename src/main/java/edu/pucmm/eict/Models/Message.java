package edu.pucmm.eict.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMessage;
    @Column(nullable = false)
    private Date fechaGeneracion;
    @Column(nullable = false)
    private long idDispositivo;
    @Column(nullable = false)
    private float temperatura;
    @Column(nullable = false)
    private float humedad;

    public Message() {
    }

    public Message(Date fechaGeneracion, long idDispositivo, float temperatura, float humedad) {
        this.fechaGeneracion = fechaGeneracion;
        this.idDispositivo = idDispositivo;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", fechaGeneracion=" + fechaGeneracion +
                ", idDispositivo=" + idDispositivo +
                ", temperatura=" + temperatura +
                ", humedad=" + humedad +
                '}';
    }
}
