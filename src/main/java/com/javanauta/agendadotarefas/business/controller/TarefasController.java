package com.javanauta.agendadotarefas.business.controller;

import com.javanauta.agendadotarefas.business.TarefaService;
import com.javanauta.agendadotarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class TarefasController {

    private final TarefaService tarefasService;

    @PostMapping("/tarefas")
    public ResponseEntity<TarefasDTO> gravarTarefa(@RequestBody TarefasDTO dto,
                                                   @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));

    }
}
