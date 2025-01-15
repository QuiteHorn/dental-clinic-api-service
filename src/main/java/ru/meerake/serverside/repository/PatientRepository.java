package ru.meerake.serverside.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.meerake.serverside.model.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    List<Patient> findAll();
    Patient findById(long id);
}
