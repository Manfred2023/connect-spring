package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Creneau;
import net.campus.connect.service.CreneauService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creneaux")
public class CreneauController {

    private final CreneauService service;

    public CreneauController(CreneauService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Creneau>> create(@RequestBody Creneau creneau) {
        Creneau saved = service.create(creneau);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Créneau créé avec succès", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Creneau>>> getAll() {
        return ResponseEntity.ok(
                ApiResponse.ok("Liste des créneaux", service.getAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Creneau>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.ok("Créneau trouvé", service.getById(id))
        );
    }
}