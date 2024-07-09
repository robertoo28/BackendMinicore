package com.roberto.minicore.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTarea;
    private String descripción;
    @Temporal(TemporalType.DATE)
    private Date fechaEmpezar;
    private int estimado;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;

    // Getters and Setters

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }


    public Date getFechaEmpezar() {
        return fechaEmpezar;
    }

    public void setFechaEmpezar(Date fechaEmpezar) {
        this.fechaEmpezar = fechaEmpezar;
    }

    public int getEstimado() {
        return estimado;
    }

    public void setEstimado(int estimado) {
        this.estimado = estimado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}