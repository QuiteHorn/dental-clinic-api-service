package ru.meerake.serverside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.meerake.serverside.model.Dentist;
import ru.meerake.serverside.service.DentistService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    @Autowired
    private DentistService dentistService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Dentist addDentist(@RequestBody Dentist dentist) {
        return dentistService.addDentist(dentist);
    }

    @GetMapping()
    public List<Dentist> getAllDentists() {
        return dentistService.getAllDentists();
    }

    @GetMapping("/{id}")
    public Dentist getDentist(@PathVariable long id) {
        return dentistService.getDentistById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Dentist updateDentist(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return dentistService.updateDentist(id, updates);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteDentist(@PathVariable long id) {
        dentistService.deleteDentistById(id);
    }
}
