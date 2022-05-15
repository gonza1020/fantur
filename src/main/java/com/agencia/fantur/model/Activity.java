package com.agencia.fantur.model;

import com.agencia.fantur.enums.ActivityType;
import com.agencia.fantur.enums.Schedule;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "activity")
public class Activity extends BaseEntity<Long> {

    @Column(name = "type", nullable = false)
    private ActivityType type;

    @Column(name = "schedule", nullable = false)
    private Schedule schedule;

    @Column(name = "price", nullable = false)
    private double price;

}
