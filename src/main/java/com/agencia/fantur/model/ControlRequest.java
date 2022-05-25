package com.agencia.fantur.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlRequest {
    private long cuit;
    private Date fecha_incio;
    private Date fecha_fin;
    private BigDecimal precio;
}
