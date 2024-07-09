package com.roberto.minicore.controllers;


import com.roberto.minicore.model.Tarea;
import com.roberto.minicore.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/tareas/pasadas-estimado")
    public List<Tarea> getTareasPasadasEstimado(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return tareaService.getTareasPasadasEstimado(startDate, endDate);
    }
}