package com.agencia.fantur.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="residence")
public class Residence extends BaseEntity<Long> {

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "since", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Qatar")
    private Date since;

    @Column(name = "end", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Qatar")
    private Date end;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;
}
