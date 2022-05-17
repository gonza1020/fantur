package com.agencia.fantur.repository;

import com.agencia.fantur.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends BaseRepository<Ticket,Long>{

    //hacer llamada a DB para buscar por destino
    public default ResponseEntity<Ticket> getByDestiny(String destiny) {
        return null;
    }
}
