package com.agencia.fantur.model;


import com.agencia.fantur.enums.TicketType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "ticket")
public class Ticket extends BaseEntity<Long> {
// Premium?
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "ticket_type", nullable = false)
    private TicketType ticketType;
    @Column(name = "departure_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Qatar")
    private Date departureDate;
    @Column(name = "return_date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Qatar")
    private Date returnDate;

    //private City from;
    //private City destiny;
}
