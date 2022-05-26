package com.agencia.fantur.model;

import lombok.Data;

import java.util.Date;

@Data
public class ControlResponse {
    private int id;
    private long cuit;
    private Date fecha_creacion;
    private Date fecha_incio;
    private Date fecha_fin;
    private int precio;
    private boolean aprobada;
}
