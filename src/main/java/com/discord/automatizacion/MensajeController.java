package com.discord.automatizacion;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MensajeController {

    private final MensajeServicio mensajeServicio;

    @Autowired
    public MensajeController(MensajeServicio mensajeServicio){
        this.mensajeServicio = mensajeServicio;
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearMensaje(@Valid @RequestBody MensajeDTO mensajeDTO){
        Mensaje mensajeGuardado = mensajeServicio.guardaMensaje(mensajeDTO);
        return ResponseEntity.ok(mensajeGuardado);
    }

    @GetMapping
    public List<Mensaje> mostrarMensajes(){
        return mensajeServicio.listarMensajes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable Long id){
        mensajeServicio.eliminaMensaje(id);
        return ResponseEntity.noContent().build();
    }

}
