package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.DossierEtudiant;
import net.campus.connect.service.DossierEtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dossiers")
public class DossierEtudiantController {

    private final DossierEtudiantService service;

    public DossierEtudiantController(DossierEtudiantService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<DossierEtudiant>> create(@RequestBody DossierEtudiant dossier) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Dossier créé avec succès", service.save(dossier)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<DossierEtudiant>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok("Liste des dossiers", service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DossierEtudiant>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(ApiResponse.ok("Dossier trouvé", service.getById(id)));
    }

    @GetMapping("/etudiant/{etudiantId}")
    public ResponseEntity<ApiResponse<DossierEtudiant>> getByEtudiant(@PathVariable Integer etudiantId) {
        return ResponseEntity.ok(ApiResponse.ok("Dossier trouvé", service.getByEtudiant(etudiantId)));
    }

    @GetMapping("/filiere/{filiereId}")
    public ResponseEntity<ApiResponse<List<DossierEtudiant>>> getByFiliere(@PathVariable Integer filiereId) {
        return ResponseEntity.ok(ApiResponse.ok("Dossiers de la filière", service.getByFiliere(filiereId)));
    }

    @GetMapping("/statut/{statut}")
    public ResponseEntity<ApiResponse<List<DossierEtudiant>>> getByStatut(
            @PathVariable DossierEtudiant.StatutDossier statut) {
        return ResponseEntity.ok(ApiResponse.ok("Dossiers par statut", service.getByStatut(statut)));
    }

    @PatchMapping("/{id}/statut")
    public ResponseEntity<ApiResponse<DossierEtudiant>> updateStatut(
            @PathVariable Integer id,
            @RequestParam DossierEtudiant.StatutDossier statut) {
        return ResponseEntity.ok(ApiResponse.ok("Statut mis à jour", service.updateStatut(id, statut)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Dossier supprimé", null));
    }
}