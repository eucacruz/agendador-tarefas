package com.javanauta.agendadotarefas.business;

import com.javanauta.agendadotarefas.Infrastructore.entity.TarefasEntity;
import com.javanauta.agendadotarefas.Infrastructore.enums.StatusNotificacaoEnum;
import com.javanauta.agendadotarefas.Infrastructore.repository.TarefasRepository;
import com.javanauta.agendadotarefas.Infrastructore.security.JwtUtil;
import com.javanauta.agendadotarefas.business.dto.TarefasDTO;
import com.javanauta.agendadotarefas.business.mapper.TarefaConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefaService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(
                tarefasRepository.save(entity));

    }

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo(
            LocalDateTime dataInicial,
            LocalDateTime dataFinal) {
        return tarefasConverter.paraListaTarefasDTO(
        tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));

    }

public List<TarefasDTO> buscaTarefasPorEmail(String token){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        List<TarefasEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);

        return tarefasConverter.paraListaTarefasDTO(listaTarefas);
}

}
