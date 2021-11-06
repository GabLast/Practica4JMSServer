package edu.pucmm.eict.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMessage;
    private LocalDateTime fechaGeneracion;
    private long idDispositivo;
    private float temperatura;
    private float humedad;

    public Message() {
    }

    public Message(LocalDateTime fechaGeneracion, long idDispositivo, float temperatura, float humedad) {
        this.fechaGeneracion = fechaGeneracion;
        this.idDispositivo = idDispositivo;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }
}
