package ru.meerake.serverside.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.meerake.serverside.model.Dentist;

import java.util.List;

@Repository
public interface DentistRepository extends CrudRepository<Dentist, Long> {
    Dentist findById(long id);
    List<Dentist> findAll();
}
