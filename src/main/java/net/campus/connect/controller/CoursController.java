package net.campus.connect.controller;


import net.campus.connect.clientDto.CouseCreateDto;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Cours;
import net.campus.connect.model.Departement;
import net.campus.connect.model.Etudiant;
import net.campus.connect.model.Professeur;
import net.campus.connect.service.CoursService;
import net.campus.connect.service.DepartementService;
import net.campus.connect.service.ProfesseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    private final CoursService service;
    private final ProfesseurService professeurService;
    private final DepartementService departementService;

    public CoursController(CoursService service, ProfesseurService professeurService, DepartementService departementService) {
        this.service = service;
        this.professeurService = professeurService;
        this.departementService = departementService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Cours>> create(@RequestBody CouseCreateDto couseCreateDto) {
        Cours cours;
        Professeur professeur;
        Departement departement;

        try{
            professeur = professeurService.getById(couseCreateDto.getProfesseur_id());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try{
            departement = departementService.getById(couseCreateDto.getDepartement_id());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }


        try{

            cours = service.save(new Cours(
                    couseCreateDto.getIntitule(),
                    couseCreateDto.getCode(),
                    couseCreateDto.getDescription(),
                    couseCreateDto.getVolume_horaire_en_heure(),
                    couseCreateDto.getCredit(),
                    professeur ,
                    departement
            ));
        } catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Cours créé avec succès",cours ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Cours>>> getAll() {
        List<Cours> courses = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Courses retrieved successfully", courses));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Cours>> getById(@PathVariable Integer id) {
        Cours course = service.getById(id);
        return ResponseEntity.ok(ApiResponse.ok("Course retrieved successfully", course));
    }

     @GetMapping("/departement/{departementId}")
    public ResponseEntity<ApiResponse<List<Cours>>> getByCountry(@PathVariable Integer departementId) {
        List<Cours> courses = service.getByDepartementId(departementId);
        return ResponseEntity.ok(ApiResponse.ok("Courses retrieved successfully", courses));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Course deleted successfully", null));
    }
}
