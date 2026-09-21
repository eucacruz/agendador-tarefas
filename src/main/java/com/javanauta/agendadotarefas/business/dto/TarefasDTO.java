package com.javanauta.agendadotarefas.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javanauta.agendadotarefas.Infrastructore.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TarefasDTO {

    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAtualizacao;
    private StatusNotificacaoEnum statusNotificacaoEnum;
}
