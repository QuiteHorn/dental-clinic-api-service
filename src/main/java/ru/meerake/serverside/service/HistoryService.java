package ru.meerake.serverside.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.meerake.serverside.model.Dentist;
import ru.meerake.serverside.model.Visit;
import ru.meerake.serverside.repository.HistoryRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(@NotNull final HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public Visit getVisitById(@NotNull long id) {
        return historyRepository.findById(id);
    }

    public List<Visit> getAllVisits() {
        return historyRepository.findAll();
    }

    public List<Visit> getAllVisitsByPatient(@NotNull long patientId) {
        return historyRepository.getAllByPatientid(patientId);
    }

    public List<Visit> getAllProceduresByDentist(@NotNull long dentistId) {
        return historyRepository.getAllByDentistid(dentistId);
    }

    public Visit addNewVisit(@NotNull Visit visit) {
        visit.setId(null);
        return historyRepository.save(visit);
    }

    public Visit updateVisit(long id, Map<String, Object> updates) {
        if ((historyRepository.existsById(id))) {
            var existingVisit = historyRepository.findById(id);

            updates.forEach((key, value) -> {
                switch (key) {
                    case "patientid":
                        existingVisit.setPatientid((Long) value);
                        break;
                    case "dentistid":
                        existingVisit.setDentistid((Long) value);
                        break;case "procedureid":
                        existingVisit.setProcedureid((Long) value);
                        break;
                    case "visitdate":
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        existingVisit.setVisitdate(LocalDate.parse(value.toString(), formatter));
                        break;
                }
            });

            return historyRepository.save(existingVisit);
        } else {
            return null;
        }
    }

    public void deleteVisitById(long id) {
        historyRepository.deleteById(id);
    }
}
