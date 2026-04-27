package net.campus.connect.controller;


import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.DossierEtudiant;
import net.campus.connect.model.Inscription;
import net.campus.connect.service.DossierEtudiantService;
import net.campus.connect.service.InscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moyenne")
public class MoyenneController {

    private final DossierEtudiantService dossierEtudiantService;
    private final InscriptionService inscriptionService;

    public MoyenneController(DossierEtudiantService dossierEtudiantService, InscriptionService service) {
        this.dossierEtudiantService = dossierEtudiantService;
        this.inscriptionService = service;
    }

    @GetMapping("/dossierEtudiant/{id}")
    public ResponseEntity<ApiResponse<List<Inscription>>> delete(@PathVariable Integer id) {
        DossierEtudiant dossierEtudiant;
        List<Inscription> inscriptionList;

        System.out.println("Tous commence la");
        System.out.println(id);
        try {
            dossierEtudiant =  dossierEtudiantService.getById(id);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }
        System.out.println(dossierEtudiant.getNumeroDossier());

       try {
           inscriptionList = inscriptionService.findByDossierEtudiantId(dossierEtudiant.getId());
       } catch (Exception e) {
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND)
                   .body(ApiResponse.error("Aucune inscription pour cet dossier"));
       }
        System.out.println(inscriptionList.getFirst().getGroupe().getCours().getIntitule());

        return ResponseEntity.ok(ApiResponse.ok("Course deleted successfully", inscriptionList));
    }
}
