package ru.meerake.serverside.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.meerake.serverside.model.Procedure;

import java.util.List;

@Repository
public interface ProcedureRepository extends CrudRepository<Procedure, Long> {
    Procedure findById(long id);
    List<Procedure> findAll();
}
