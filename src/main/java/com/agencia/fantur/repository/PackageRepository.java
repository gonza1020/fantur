package com.agencia.fantur.repository;

import com.agencia.fantur.model.BaseEntity;
import com.agencia.fantur.model.Package;
import com.agencia.fantur.model.StandardPackage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PackageRepository<T extends BaseEntity> extends BaseRepository<T,Long>{
    //hacer llamada a DB para buscar por destino

    @Query(
            value = "select * \n" +
                    "from package p inner join residence r   inner join city c \n" +
                    "where p.residence_id=r.id and r.city_id=c.id and c.name like %:city%",
            nativeQuery = true
    )
    List<T> findByCity(@Param("city") String city);
}
