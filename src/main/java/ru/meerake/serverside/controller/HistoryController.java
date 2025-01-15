package ru.meerake.serverside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.meerake.serverside.model.Visit;
import ru.meerake.serverside.service.HistoryService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Visit addNewVisit(@RequestBody Visit visit) {
        return historyService.addNewVisit(visit);
    }

    @GetMapping()
    public List<Visit> getAllVisits() {
        return historyService.getAllVisits();
    }

    @GetMapping("/{id}")
    public Visit getVisit(@PathVariable long id) {
        return historyService.getVisitById(id);
    }

    @GetMapping("/patient/{id}")
    public List<Visit> getAllVisitsByPatient(@PathVariable long id) {
        return historyService.getAllVisitsByPatient(id);
    }

    @GetMapping("/dentist/{id}")
    public List<Visit> getAllProceduresByDentist(@PathVariable long id) {
        return historyService.getAllProceduresByDentist(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Visit updateVisit(@PathVariable long id, @RequestBody Map<String, Object> updates) {
        return historyService.updateVisit(id, updates);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteVisit(@PathVariable long id) {
        historyService.deleteVisitById(id);
    }
}
