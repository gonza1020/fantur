package com.agencia.fantur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenericRepository<T> extends JpaRepository<T,Long> {
}
