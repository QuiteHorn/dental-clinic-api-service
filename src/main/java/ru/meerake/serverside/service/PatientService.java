package ru.meerake.serverside.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ru.meerake.serverside.model.Patient;
import ru.meerake.serverside.repository.PatientRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(@NotNull PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        patient.setId(null);
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(long id) {
        return patientRepository.findById(id);
    }

    public Patient updatePatient(long id, Map<String, Object> updates) {
        if ((patientRepository.existsById(id))) {
            var existingPatient = patientRepository.findById(id);

            updates.forEach((key, value) -> {
                switch (key) {
                    case "firstname":
                        existingPatient.setFirstname((String) value);
                        break;
                    case "lastname":
                        existingPatient.setLastname((String) value);
                        break;
                    case "birthdate":
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        existingPatient.setBirthdate(LocalDate.parse(value.toString(), formatter));
                        break;
                    case "phonenumber":
                        existingPatient.setPhonenumber((String) value);
                        break;
                    case "address":
                        existingPatient.setAddress((String) value);
                        break;
                    case "email":
                        existingPatient.setEmail((String) value);
                        break;
                }
            });

            return patientRepository.save(existingPatient);
        } else {
            return null;
        }
    }

    public void deletePatientById(long id) {
        patientRepository.deleteById(id);
    }
}
