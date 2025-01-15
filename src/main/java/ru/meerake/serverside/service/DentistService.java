package ru.meerake.serverside.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.meerake.serverside.model.Dentist;
import ru.meerake.serverside.model.Patient;
import ru.meerake.serverside.repository.DentistRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class DentistService {
    private final DentistRepository dentistRepository;

    public DentistService(@NotNull DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public Dentist addDentist(Dentist dentist) {
        dentist.setId(null);
        return dentistRepository.save(dentist);
    }

    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    public Dentist getDentistById(long id) {
        return dentistRepository.findById(id);
    }

    public Dentist updateDentist(long id, Map<String, Object> updates) {
        if ((dentistRepository.existsById(id))) {
            var existingDentist = dentistRepository.findById(id);

            updates.forEach((key, value) -> {
                switch (key) {
                    case "firstname":
                        existingDentist.setFirstname((String) value);
                        break;
                    case "lastname":
                        existingDentist.setLastname((String) value);
                        break;
                    case "birthdate":
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        existingDentist.setBirthdate(LocalDate.parse(value.toString(), formatter));
                        break;
                    case "phonenumber":
                        existingDentist.setPhonenumber((String) value);
                        break;
                    case "address":
                        existingDentist.setAddress((String) value);
                        break;
                    case "email":
                        existingDentist.setEmail((String) value);
                        break;
                    case "experience":
                        existingDentist.setExperience(Integer.valueOf(value.toString()));
                        break;
                    case "isable":
                        existingDentist.setIsable(Boolean.valueOf(value.toString()));
                        break;
                }
            });

            return dentistRepository.save(existingDentist);
        } else {
            return null;
        }
    }

    public void deleteDentistById(long id) {
        dentistRepository.deleteById(id);
    }
}
