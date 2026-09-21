package com.javanauta.agendadotarefas.Infrastructore.repository;

import com.javanauta.agendadotarefas.Infrastructore.entity.TarefasEntity;
import org.springframework.cglib.core.Local;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {

    List<TarefasEntity> findByDataEventoBetween(LocalDateTime dataInicial, LocalDateTime LocalDateFinal);

    List<TarefasEntity> findByEmailUsuario(String email);
}
