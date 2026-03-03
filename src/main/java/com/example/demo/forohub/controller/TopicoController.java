package com.example.demo.forohub.controller;

import com.example.demo.forohub.dto.DatosRegistroTopico;
import com.example.demo.forohub.model.Topico;
import com.example.demo.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")

public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Topico> registrar(@RequestBody @Valid DatosRegistroTopico datos){
        Topico topico = service.crearTopico(datos);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<Page<Topico>> listar(Pageable paginacion){
        return ResponseEntity.ok(service.listarTopicos(paginacion));
    }
}