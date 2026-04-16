package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Professeur;
import net.campus.connect.service.ProfesseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {

    private final ProfesseurService service;

    public ProfesseurController(ProfesseurService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Professeur>> create(@RequestBody Professeur professeur) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Professeur créé avec succès", service.save(professeur)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Professeur>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok("Liste des professeurs", service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Professeur>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(ApiResponse.ok("Professeur trouvé", service.getById(id)));
    }

    @GetMapping("/specialite/{specialite}")
    public ResponseEntity<ApiResponse<List<Professeur>>> getBySpecialite(@PathVariable String specialite) {
        return ResponseEntity.ok(ApiResponse.ok("Professeurs spécialité " + specialite, service.getBySpecialite(specialite)));
    }

    @GetMapping("/grade/{grade}")
    public ResponseEntity<ApiResponse<List<Professeur>>> getByGrade(@PathVariable String grade) {
        return ResponseEntity.ok(ApiResponse.ok("Professeurs grade " + grade, service.getByGrade(grade)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Professeur supprimé", null));
    }
}