package com.agencia.fantur.model;


import com.agencia.fantur.enums.TicketType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity<Long> {
// Premium?
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "ticket_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    @Column(name = "departure_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Qatar")
    private Date departureDate;
    @Column(name = "return_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Qatar")
    private Date returnDate;

    @ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_from_id", nullable = false)
    private City from;

    @ManyToOne(targetEntity = City.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "city_to_id", nullable = false)
    private City to;

    //private City from;
    //private City destiny;
}
