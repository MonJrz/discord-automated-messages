package com.discord.automatizacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class MensajeServicio {

    private final MensajeRepo mensajeRepo;
    private final WebClient webClient;
    private final String DISCORD_WEBHOOK_URL = "https://discord.com/api/webhooks/1339294033276702771/AaY-PLGXTo83P4-aYUznPKw_QKJdZSXhgx0YQ0M0f2qMdyOoRLD2JLc_mh8BVx-z4-De"; //Insertar URL de tu WebHook


    @Autowired
    public MensajeServicio(MensajeRepo mensajeRepo) {
        this.mensajeRepo = mensajeRepo;
        this.webClient = WebClient.create();
    }

    //Guarda mensajes
    public Mensaje guardaMensaje(MensajeDTO mensajeDTO) {
        System.out.println("Mensaje de prueba:" + mensajeDTO);
        Mensaje mensaje = new Mensaje(mensajeDTO.getTexto(),
                mensajeDTO.getFecha());
        return mensajeRepo.save(mensaje);
    }

    //Muestra lista de mensajes
    public List<Mensaje> listarMensajes(){
        return mensajeRepo.findAll();
    }

    //Elimina mensajes
    public void eliminaMensaje(Long id){
        mensajeRepo.deleteById(id);
    }

    //Envía mensajes programados
    @Scheduled(fixedRate = 600000)
    public void enviarMensaje(){
        List<Mensaje> mensajesPorEnviar = mensajeRepo.findByFechaBefore(LocalDateTime.now());
        for(Mensaje mensaje : mensajesPorEnviar){
            enviarADiscord(mensaje);
            mensajeRepo.delete(mensaje);
        }
    }

    //Envía mensaje a bot de Discord
    private void enviarADiscord(Mensaje mensaje){
        if (DISCORD_WEBHOOK_URL.isEmpty()){
            System.out.println("❌ No se ha configurado la URL del webhook de Discord.");
            return;
        }

        //Cuerpo del mensaje JSON
        Map<String, String> payload = Map.of("content", mensaje.getTexto());

        //Enviar POST al webhook
        webClient.post()
                .uri(DISCORD_WEBHOOK_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(payload)
                .retrieve()
                .toBodilessEntity()
                .block(); // Bloquea hasta que se complete la solicitud

        System.out.println("✅ Mensaje enviado a Discord: " + mensaje.getTexto());

    }
}
