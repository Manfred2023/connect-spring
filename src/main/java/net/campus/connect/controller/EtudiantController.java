package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Etudiant;
import net.campus.connect.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService service;

    public EtudiantController(EtudiantService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Etudiant>> create(@RequestBody Etudiant etudiant) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Etudiant créé avec succès", service.save(etudiant)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Etudiant>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok("Liste des étudiants", service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Etudiant>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(ApiResponse.ok("Etudiant trouvé", service.getById(id)));
    }

    @GetMapping("/matricule/{matricule}")
    public ResponseEntity<ApiResponse<Etudiant>> getByMatricule(@PathVariable String matricule) {
        return ResponseEntity.ok(ApiResponse.ok("Etudiant trouvé", service.getByMatricule(matricule)));
    }

 /*   @GetMapping("/filiere/{filiere}")
    public ResponseEntity<ApiResponse<List<Etudiant>>> getByFiliere(@PathVariable String filiere) {
        return ResponseEntity.ok(ApiResponse.ok("Etudiants de la filière " + filiere, service.getByFiliere(filiere)));
    }

    @GetMapping("/niveau/{niveau}")
    public ResponseEntity<ApiResponse<List<Etudiant>>> getByNiveau(@PathVariable int niveau) {
        return ResponseEntity.ok(ApiResponse.ok("Etudiants du niveau " + niveau, service.getByNiveau(niveau)));
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Etudiant supprimé", null));
    }
}