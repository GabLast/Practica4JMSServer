package edu.pucmm.eict.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GraphData {
    private long idDispositivo;
    private List<Float> temps;
    private List<Float> humidities;
    private List<LocalDateTime> times;

    public GraphData() {
        this.temps = new ArrayList<>();
        this.humidities = new ArrayList<>();
        this.times = new ArrayList<>();
    }

    public long getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public List<Float> getTemps() {
        return temps;
    }

    public void setTemps(List<Float> temps) {
        this.temps = temps;
    }

    public List<Float> getHumidities() {
        return humidities;
    }

    public void setHumidities(List<Float> humidities) {
        this.humidities = humidities;
    }

    public List<LocalDateTime> getTimes() {
        return times;
    }

    public void setTimes(List<LocalDateTime> times) {
        this.times = times;
    }
}
