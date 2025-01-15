package ru.meerake.serverside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.meerake.serverside.model.Patient;
import ru.meerake.serverside.service.PatientService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @GetMapping()
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable long id) {
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Patient updatePatient(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return patientService.updatePatient(id, updates);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deletePatient(@PathVariable long id) {
        patientService.deletePatientById(id);
    }
}
