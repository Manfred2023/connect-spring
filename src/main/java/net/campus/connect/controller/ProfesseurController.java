package net.campus.connect.controller;

import net.campus.connect.clientDto.ProfesseurCreateDto;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.City;
import net.campus.connect.model.Departement;
import net.campus.connect.model.Etudiant;
import net.campus.connect.model.Professeur;
import net.campus.connect.service.CityService;
import net.campus.connect.service.DepartementService;
import net.campus.connect.service.ProfesseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {

    private final ProfesseurService service;
    private final CityService cityService;
    private final DepartementService departementService;

    public ProfesseurController(ProfesseurService service, CityService cityService, DepartementService departementService) {
        this.service = service;
        this.cityService = cityService;
        this.departementService = departementService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Professeur>> create(@RequestBody ProfesseurCreateDto professeurCreateDto) {
        Professeur professeur;
        Departement departement;
        City city;

        //User check
        try{
            city = cityService.getById(professeurCreateDto.getCityId());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        //Departement check
        try{
            departement = departementService.getById(professeurCreateDto.getDepartementId());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }


        try{

            professeur = service.save(new Professeur(
                    null,
                    professeurCreateDto.getNom(),
                    professeurCreateDto.getPrenom(),
                    professeurCreateDto.getEmail(),
                    professeurCreateDto.getMobile(),
                    city,
                    professeurCreateDto.isPermanent() ,
                    departement,
                    professeurCreateDto.getDateRecrutement(),
                    professeurCreateDto.getAnciennete(),
                    professeurCreateDto.getMdp()
            ));
        } catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Professeur créé avec succès",professeur ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Professeur>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok("Liste des professeurs", service.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Professeur>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(ApiResponse.ok("Professeur trouvé", service.getById(id)));
    }
/*
    @GetMapping("/specialite/{specialite}")
    public ResponseEntity<ApiResponse<List<Professeur>>> getBySpecialite(@PathVariable String specialite) {
        return ResponseEntity.ok(ApiResponse.ok("Professeurs spécialité " + specialite, service.getBySpecialite(specialite)));
    }*/

/*    @GetMapping("/grade/{grade}")
    public ResponseEntity<ApiResponse<List<Professeur>>> getByGrade(@PathVariable String grade) {
        return ResponseEntity.ok(ApiResponse.ok("Professeurs grade " + grade, service.getByGrade(grade)));
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Professeur supprimé", null));
    }
}