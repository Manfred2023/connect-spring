package net.campus.connect.controller;

import net.campus.connect.clientDto.InscriptionCreateDto;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.exception.CapaciteDepasseeException;
import net.campus.connect.model.DossierEtudiant;
import net.campus.connect.model.Etudiant;
import net.campus.connect.model.Groupe;
import net.campus.connect.model.Inscription;
import net.campus.connect.service.DossierEtudiantService;
import net.campus.connect.service.GroupeService;
import net.campus.connect.service.InscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    private final InscriptionService service;
    private final DossierEtudiantService dossierEtudiantService;
    private final GroupeService groupeService;

    public InscriptionController(InscriptionService service, DossierEtudiantService dossierEtudiantService, GroupeService groupeService) {
        this.service = service;
        this.dossierEtudiantService = dossierEtudiantService;
        this.groupeService = groupeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Inscription>> inscrire(@RequestBody InscriptionCreateDto inscriptionCreateDto) {
        Inscription inscription;
        List<Inscription> inscriptions;
        DossierEtudiant dossierEtudiant;
        Groupe groupe;

        LocalDateTime date = LocalDateTime.now();


        try{
            dossierEtudiant = dossierEtudiantService.getById(inscriptionCreateDto.getDossier_etudiant_id());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try{
            groupe = groupeService.getById(inscriptionCreateDto.getGroupe_id());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }


        inscriptions = service.getByGroupe(groupe.getId());

        if(inscriptions.size() >= groupe.getCapMax()){

            throw new CapaciteDepasseeException("Place limite atteint");
        }


        try{

            inscription = service.inscrire(new Inscription(
                   dossierEtudiant,
                    groupe,
                    date.toLocalDate(),true
            ));
        } catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Inscription réussie", inscription));
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