package com.agencia.fantur.model;

import com.agencia.fantur.enums.ActivityType;
import com.agencia.fantur.enums.Schedule;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "activity")
public class Activity extends BaseEntity<Long> {

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @Column(name = "schedule", nullable = false)
    @Enumerated(EnumType.STRING)
    private Schedule schedule;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description")
    private String description;
}
