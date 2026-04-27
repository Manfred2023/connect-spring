package net.campus.connect.controller;

import net.campus.connect.clientDto.DossierEtudiantDto;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Axe;
import net.campus.connect.model.DossierEtudiant;
import net.campus.connect.model.Etudiant;
import net.campus.connect.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dossiers")
public class DossierEtudiantController {

    private final DossierEtudiantService service;
    private final EtudiantService etudiantService;
    private final AxeService axeService;

    public DossierEtudiantController(DossierEtudiantService service, EtudiantService etudiantService, AxeService axeService) {
        this.service = service;
        this.etudiantService = etudiantService;
        this.axeService = axeService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<DossierEtudiant>> create(@RequestBody DossierEtudiantDto dossierEtudiantDto) {
        DossierEtudiant dossierEtudiant;
        Etudiant etudiant;
        Axe axe;
        try{
            etudiant =  etudiantService.getById(dossierEtudiantDto.getEtudiantId());
        } catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try{
            axe =  axeService.getById(dossierEtudiantDto.getAxeId());
        } catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try {

            dossierEtudiant = service.save(
                  new DossierEtudiant(
                          null,
                            etudiant,
                            dossierEtudiantDto.getNumeroDossier(),
                            dossierEtudiantDto.isFormIni(),
                            dossierEtudiantDto.getAnneAcademique(),
                            axe,
                            dossierEtudiantDto.isCurrent()
                    )
            );


        }catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Dossier créé avec succès", dossierEtudiant));
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
/*
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
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Dossier supprimé", null));
    }
}