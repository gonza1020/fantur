package com.agencia.fantur.repository;

import com.agencia.fantur.model.BaseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


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

    @Query(
            value = "select * from package p inner join package_activities pa inner join activity a \n" +
	                "where p.id = pa.package_id and a.id = pa.activities_id and a.type like %:activity%",
            nativeQuery = true
    )
    Set<T> findByActivity (@Param("activity") String Activity);

    @Query(
            value = "select * from package p inner join standard_package sp on p.id = sp.id inner join premiumpackage pp on p.id=pp.id",
            nativeQuery = true
    )
    Set<T> findAllPackage ();
}
