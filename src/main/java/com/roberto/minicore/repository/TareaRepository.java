package com.roberto.minicore.repository;

import com.roberto.minicore.model.Tarea;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    List<Tarea> findByEstadoAndFechaEmpezarBetween(String estado, Date startDate, Date endDate);

}