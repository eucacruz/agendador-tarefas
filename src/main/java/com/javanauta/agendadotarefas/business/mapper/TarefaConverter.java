package com.javanauta.agendadotarefas.business.mapper;


import com.javanauta.agendadotarefas.Infrastructore.entity.TarefasEntity;
import com.javanauta.agendadotarefas.business.dto.TarefasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TarefaConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);

    List<TarefasEntity>  paraListaTarefasEntityList(List<TarefasDTO> dto);
    List<TarefasDTO> paraListaTarefasDTO(List<TarefasEntity> enteties);
}
