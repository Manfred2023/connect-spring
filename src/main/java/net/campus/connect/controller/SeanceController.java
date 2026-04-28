package net.campus.connect.controller;

import net.campus.connect.clientDto.SeanceDto;
import net.campus.connect.clientDto.StudentTimeTable;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.exception.ConflitHoraireException;
import net.campus.connect.model.*;
import net.campus.connect.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/seances")
public class SeanceController {

    private final SeanceService service;
    private final CreneauService creneauService;
    private final GroupeService groupeService;
    private final SalleService salleService;
    private final DossierEtudiantService dossierEtudiantService;
    private final InscriptionService inscriptionService;

    public SeanceController(SeanceService service, CreneauService creneauService, GroupeService groupeService, SalleService salleService,  DossierEtudiantService dossierEtudiantService, InscriptionService inscriptionService) {
        this.service = service;
        this.creneauService = creneauService;
        this.groupeService = groupeService;
        this.salleService = salleService;
        this.dossierEtudiantService = dossierEtudiantService;
        this.inscriptionService = inscriptionService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Seance>> create(@RequestBody SeanceDto seanceDto) {
        Seance seance;
        Creneau creneau;
        Salle salle;
        Groupe groupe;

        try{
            creneau = creneauService.getById(seanceDto.getCreneau());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try{
            salle = salleService.getById(seanceDto.getSalle());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try{
            groupe = groupeService.getById(seanceDto.getGroupe());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try {
            Seance saved = service.create(new Seance(null,groupe,salle,creneau));
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ApiResponse.ok("Séance créée avec succès", saved));

        } catch (ConflitHoraireException e) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ApiResponse.ok(e.getMessage(), null));

        }
        catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Erreur interne"));
        }

    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Seance>>> getAll() {
        return ResponseEntity.ok(
                ApiResponse.ok("Liste des séances", service.getAll())
        );
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<ApiResponse<List<Seance>>> getStudentTimeTable(@PathVariable Integer id) {

        DossierEtudiant dossierEtudiant;
        List<Seance> seances;
        List<Inscription> inscriptionList;

        try {
            dossierEtudiant = dossierEtudiantService.getById(id);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Étudiant introuvable"));
        }

        try {
            inscriptionList = inscriptionService.findByDossierEtudiantId(dossierEtudiant.getId());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error("Aucune inscription trouvée"));
        }

        List<Groupe> groupes = inscriptionList.stream()
                .map(Inscription::getGroupe)
                .toList();

        seances = service.findByGroupeIn(groupes);

        return ResponseEntity.ok(
                ApiResponse.ok("Emploi du temps étudiant", seances)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Seance>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ApiResponse.ok("Séance trouvée", service.getById(id))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(
                ApiResponse.ok("Séance supprimée", null)
        );
    }
}