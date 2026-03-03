package com.example.demo.forohub.service;

import com.example.demo.forohub.dto.DatosRegistroTopico;
import com.example.demo.forohub.exception.TopicoDuplicadoException;
import com.example.demo.forohub.model.Topico;
import com.example.demo.forohub.repository.TopicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class TopicoService {

    private final TopicoRepository repository;

    public TopicoService(TopicoRepository repository){
        this.repository = repository;
    }

    public Topico crearTopico(DatosRegistroTopico datos){

        repository.findByTituloAndMensaje(datos.titulo(), datos.mensaje())
                .ifPresent(t -> {
                    throw new TopicoDuplicadoException("Ya existe un tópico con el mismo título y mensaje");
                });

        Topico topico = Topico.builder()
                .titulo(datos.titulo())
                .mensaje(datos.mensaje())
                .fechaCreacion(LocalDateTime.now())
                .status(true)
                .autor(datos.autor())
                .curso(datos.curso())
                .build();

        return repository.save(topico);
    }

    public Page<Topico> listarTopicos(Pageable paginacion){
        return repository.findAll(paginacion);
    }
}
