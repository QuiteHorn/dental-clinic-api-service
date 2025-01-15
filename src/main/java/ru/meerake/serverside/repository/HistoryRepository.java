package ru.meerake.serverside.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.meerake.serverside.model.Visit;

import java.util.List;

@Repository
public interface HistoryRepository extends CrudRepository<Visit, Long> {
    List<Visit> findAll();
    Visit findById(long id);
    List<Visit> getAllByDentistid(@NotNull long dentistId);
    List<Visit> getAllByPatientid(@NotNull long patientId);
}
