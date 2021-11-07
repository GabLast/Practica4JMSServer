package edu.pucmm.eict.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMessage;
    @Column(nullable = false)
    private LocalDateTime fechaGeneracion;
    @Column(nullable = false)
    private long idDispositivo;
    @Column(nullable = false)
    private float temperatura;
    @Column(nullable = false)
    private float humedad;

    public Message() {
    }

    public Message(LocalDateTime fechaGeneracion, long idDispositivo, float temperatura, float humedad) {
        this.fechaGeneracion = fechaGeneracion;
        this.idDispositivo = idDispositivo;
        this.temperatura = temperatura;
        this.humedad = humedad;
    }

    public long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(long idMessage) {
        this.idMessage = idMessage;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public long getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(float humedad) {
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
