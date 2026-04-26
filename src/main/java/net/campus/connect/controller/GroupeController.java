package net.campus.connect.controller;

import net.campus.connect.clientDto.GroupeCreate;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.*;
import net.campus.connect.service.CoursService;
import net.campus.connect.service.GroupeService;
import net.campus.connect.service.GroupeTypeService;
import net.campus.connect.service.ProfesseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")
public class GroupeController {

    private final GroupeService service;
    private final ProfesseurService professeurService;
    private final GroupeTypeService groupeTypeService;
    private final CoursService coursService;

    public GroupeController(GroupeService service, ProfesseurService professeurService, GroupeTypeService groupeTypeService, CoursService coursService) {
        this.service = service;
        this.professeurService = professeurService;
        this.groupeTypeService = groupeTypeService;
        this.coursService = coursService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Groupe>> create(@RequestBody GroupeCreate groupeCreate) {
        Professeur professeur;
        GroupeType groupeType;
        Cours cours;
        Groupe groupe;

        try{
            professeur = professeurService.getById(groupeCreate.getProfesseur_id());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try{
            groupeType = groupeTypeService.getById(groupeCreate.getGroupe_type_id());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try{
            cours = coursService.getById(groupeCreate.getCours_id());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }
        try{

            groupe = service.create(new Groupe(
                    groupeCreate.getCapMax(),
                    professeur,
                    groupeType,
                    cours
            ));
        } catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Groupe créé avec succès",groupe ));



    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Groupe>>> getAll() {
        List<Groupe> list = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Groupes retrieved successfully", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Groupe>> getById(@PathVariable Integer id) {
        Groupe groupe = service.getById(id);
        return ResponseEntity.ok(ApiResponse.ok("Groupe retrieved successfully", groupe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Groupe>> update(
            @PathVariable Integer id,
            @RequestBody Groupe groupe
    ) {
        Groupe updated = service.update(id, groupe);
        return ResponseEntity.ok(ApiResponse.ok("Groupe updated successfully", updated));
    }

    @GetMapping("/cours/{coursId}")
    public ResponseEntity<ApiResponse<List<Groupe>>> getByCountry(@PathVariable Integer coursId) {
        List<Groupe> cities = service.getByCours(coursId);
        return ResponseEntity.ok(ApiResponse.ok("coursId retrieved successfully", cities));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Groupe deleted successfully", null));
    }
}