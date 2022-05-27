package com.agencia.fantur.repository;

import com.agencia.fantur.model.BaseEntity;
import com.agencia.fantur.model.Package;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface PackageRepository extends BaseRepository<Package,Long>{
    //hacer llamada a DB para buscar por destino
    @Query(
            value = "select *, 0 as clazz_ \n" +
                    "from package p inner join residence r   inner join city c \n" +
                    "where p.residence_id=r.id and r.city_id=c.id and c.name like %:city%",
            nativeQuery = true
    )
    List<Package> findByCity(@Param("city") String city);

    @Query(
            value = "select *, 0 as clazz_ from package p inner join package_activities pa inner join activity a \n" +
	                "where p.id = pa.package_id and a.id = pa.activities_id and a.type like %:activity%",
            nativeQuery = true
    )
    Set<Package> findByActivity (@Param("activity") String Activity);

   /* @Query(
            value = "select * from package p inner join standard_package sp on p.id = sp.id inner join premiumpackage pp on p.id=pp.id",
            nativeQuery = true
    )
    Set<T> findAllPackage ();*/
}
