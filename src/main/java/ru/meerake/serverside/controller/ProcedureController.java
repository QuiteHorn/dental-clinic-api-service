package ru.meerake.serverside.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.meerake.serverside.model.Procedure;
import ru.meerake.serverside.service.ProcedureService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/procedure")
public class ProcedureController {
    @Autowired
    ProcedureService procedureService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Procedure addProcedure(@RequestBody Procedure procedure) {
        return procedureService.addProcedure(procedure);
    }

    @GetMapping()
    public List<Procedure> getAllProcedures() {
        return procedureService.getAllProcedures();
    }

    @GetMapping("/{id}")
    public Procedure getDentist(@PathVariable long id) {
        return procedureService.getProcedureById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Procedure updateProcedure(@PathVariable int id, @RequestBody Map<String, Object> updates) {
        return procedureService.updateProcedure(id, updates);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteProcedure(@PathVariable long id) {
        procedureService.deleteProcedureById(id);
    }
}
