package com.discord.automatizacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Mensaje {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String texto;
    @JsonFormat(pattern = "dd/MM/yyyy:HH:mm")
    public LocalDateTime fecha;

    public Mensaje( String texto, LocalDateTime fecha) {
        this.texto = texto;
        this.fecha = fecha;
    }

    public Mensaje (){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
