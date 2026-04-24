package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Inscription;
import net.campus.connect.service.InscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    private final InscriptionService service;

    public InscriptionController(InscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Inscription>> inscrire(@RequestBody Inscription inscription) {



        Inscription saved = service.inscrire(inscription);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Inscription réussie", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Inscription>>> getAll() {
        return ResponseEntity.ok(
                ApiResponse.ok("Liste des inscriptions", service.getAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Inscription>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.ok("Inscription trouvée", service.getById(id))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.desinscrire(id);
        return ResponseEntity.ok(ApiResponse.ok("Inscription supprimée", null));
    }
}