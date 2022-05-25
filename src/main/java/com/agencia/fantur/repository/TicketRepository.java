package com.agencia.fantur.repository;

import com.agencia.fantur.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends BaseRepository<Ticket,Long>{

    //hacer llamada a DB para buscar por destino
    @Query(
            value = "select * from ticket t inner join city c where t.city_to_id = c.id and c.name LIKE %:destiny%",
            nativeQuery = true
    )
    List<Ticket> findByTo(@Param("destiny") String destiny);

    @Query(
            value = "select * from package_ticket ta inner join ticket t\n" +
                    "where t.id= ta.ticket_id\n" +
                    " and ta.ticket_id = :id",
            nativeQuery = true
    )
    Ticket getPackageTickets(@Param("id") Long id);
}
