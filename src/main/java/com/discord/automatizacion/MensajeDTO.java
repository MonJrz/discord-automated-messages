package com.discord.automatizacion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class MensajeDTO {
    @NotBlank
    private String texto;
    @NotNull
    private LocalDateTime fecha;

    public MensajeDTO(){
    }

    public MensajeDTO(String texto, LocalDateTime fecha){
        this.texto = texto;
        this.fecha = fecha;
    }

    public @NotBlank String getTexto() {
        return texto;
    }

    public void setTexto(@NotBlank String texto) {
        this.texto = texto;
    }

    public @NotNull LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(@NotNull LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "MensajeDTO{" +
                "texto = '" + texto + '\'' +
                ", fecha = " + fecha +
                '}';
    }
}
