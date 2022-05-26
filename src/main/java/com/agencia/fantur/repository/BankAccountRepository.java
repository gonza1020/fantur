package com.agencia.fantur.repository;

import com.agencia.fantur.model.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends BaseRepository<BankAccount, Long> {
}
