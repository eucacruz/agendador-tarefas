package com.javanauta.agendadotarefas.business.mapper;


import com.javanauta.agendadotarefas.Infrastructore.entity.TarefasEntity;
import com.javanauta.agendadotarefas.business.dto.TarefasDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

}
