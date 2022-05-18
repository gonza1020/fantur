package com.agencia.fantur.repository;

import com.agencia.fantur.model.Residence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidenceRepository extends BaseRepository<Residence,Long>{

    @Query(
            value="select * from residence r inner join city c where r.city_id = c.id and c.name Like %:city% ",
            nativeQuery = true
    )
    List<Residence> findByCity(@Param("city") String city);
}
