package io.github.roquesantosdev.asyncdatabase.repository;

import io.github.roquesantosdev.asyncdatabase.entities.ApplicationLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<ApplicationLog, Integer> {

    @Query(value = "select max(id) from application_log", nativeQuery = true)
    int newestId();
}