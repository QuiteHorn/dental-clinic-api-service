package ru.meerake.serverside.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.meerake.serverside.model.Procedure;
import ru.meerake.serverside.repository.ProcedureRepository;

import java.util.List;
import java.util.Map;


@Service
public class ProcedureService {
    private final ProcedureRepository procedureRepository;

    public ProcedureService(@NotNull ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }

    public Procedure addProcedure(Procedure procedure) {
        procedure.setId(null);
        return procedureRepository.save(procedure);
    }

    public List<Procedure> getAllProcedures() {
        return procedureRepository.findAll();
    }

    public Procedure getProcedureById(long id) {
        return procedureRepository.findById(id);
    }

    public Procedure updateProcedure(long id, Map<String, Object> updates) {
        if ((procedureRepository.existsById(id))) {
            var existingProcedure = procedureRepository.findById(id);

            updates.forEach((key, value) -> {
                switch (key) {
                    case "price":
                        existingProcedure.setPrice(Integer.valueOf(value.toString()));
                        break;
                    case "name":
                        existingProcedure.setName((String) value);
                        break;
                }
            });

            return procedureRepository.save(existingProcedure);
        } else {
            return null;
        }
    }

    public void deleteProcedureById(long id) {
        procedureRepository.deleteById(id);
    }
}
