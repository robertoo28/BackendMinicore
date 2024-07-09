package com.roberto.minicore.services;
import com.roberto.minicore.model.Tarea;
import com.roberto.minicore.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getTareasPasadasEstimado(Date startDate, Date endDate) {
        List<Tarea> tareas = tareaRepository.findByEstadoAndFechaEmpezarBetween("In progress", startDate, endDate);
        List<Tarea> tareasPasadasEstimado = new ArrayList<>();

        for (Tarea tarea : tareas) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tarea.getFechaEmpezar());
            calendar.add(Calendar.DAY_OF_MONTH, tarea.getEstimado());
            Date fechaEstimadaFinal = calendar.getTime();

            if (fechaEstimadaFinal.before(new Date())) {
                tareasPasadasEstimado.add(tarea);
            }
        }

        return tareasPasadasEstimado;
    }
}
