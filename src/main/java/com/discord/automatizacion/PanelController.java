package com.discord.automatizacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class PanelController {

    private final MensajeServicio mensajeServicio;

    public PanelController(MensajeServicio mensajeServicio) {
        this.mensajeServicio = mensajeServicio;
    }

    @GetMapping("/panel")
    public String mostrarPanel(Model model) {
        List<Mensaje> mensajes = mensajeServicio.listarMensajes();
        model.addAttribute("mensajes", mensajes);
        return "panel";
    }

}
