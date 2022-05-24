package com.agencia.fantur.repository;

import com.agencia.fantur.model.user.Client;
import com.agencia.fantur.model.user.User;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends BaseRepository<Client, Long> {
}
