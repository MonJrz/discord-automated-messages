package com.discord.automatizacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProgramadorDeMensajes {
    private final MensajeServicio mensajeServicio;

    @Autowired
    public ProgramadorDeMensajes(MensajeServicio mensajeServicio){
        this.mensajeServicio = mensajeServicio;
    }

    @Scheduled(fixedRate = 60000) //Se ejecuta cada minuto
    public void  revisarYEnviarMensaje(){
        mensajeServicio.enviarMensaje();
    }
}
