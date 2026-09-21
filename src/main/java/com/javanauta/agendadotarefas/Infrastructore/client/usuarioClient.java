package com.javanauta.agendadotarefas.Infrastructore.client;

import com.javanauta.agendadotarefas.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface usuarioClient {

    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                     @RequestHeader("Authorization") String token);


}
