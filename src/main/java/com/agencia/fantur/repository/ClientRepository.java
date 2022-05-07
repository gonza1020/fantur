package com.agencia.fantur.repository;

import com.agencia.fantur.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends BaseRepository<Client, Long> {
}
