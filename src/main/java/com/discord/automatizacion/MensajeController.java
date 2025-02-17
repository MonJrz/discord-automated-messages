package com.discord.automatizacion;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Mensajes", description = "Endpoints para gestionar mensajes programados")
@RestController
@RequestMapping("/message")
public class MensajeController {

    private final MensajeServicio mensajeServicio;

    @Autowired
    public MensajeController(MensajeServicio mensajeServicio){
        this.mensajeServicio = mensajeServicio;
    }

    @Operation(summary = "Crea un mensaje programado", description = "Guarda un mensaje con una fecha programada.")
    @ApiResponse(responseCode = "200", description = "Mensaje guardado con éxito")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud")
    @PostMapping
    public ResponseEntity<Mensaje> crearMensaje(@Valid @RequestBody MensajeDTO mensajeDTO){
        Mensaje mensajeGuardado = mensajeServicio.guardaMensaje(mensajeDTO);
        return ResponseEntity.ok(mensajeGuardado);
    }

    @Operation(summary = "Lista todos los mensajes programados", description = "Retorna una lista de mensajes.")
    @GetMapping
    public List<Mensaje> mostrarMensajes(){
        return mensajeServicio.listarMensajes();
    }

    @Operation(summary = "Elimina un mensaje por ID", description = "Borra un mensaje programado usando su ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMensaje(@PathVariable Long id){
        mensajeServicio.eliminaMensaje(id);
        return ResponseEntity.noContent().build();
    }

}
