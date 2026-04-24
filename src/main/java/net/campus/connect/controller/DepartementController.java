package net.campus.connect.controller;


import net.campus.connect.clientDto.DepartementCreateDto;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.*;
import net.campus.connect.service.DepartementService;
import net.campus.connect.service.FiliereService;
import net.campus.connect.service.ProfesseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {

    private final DepartementService service;
    private final ProfesseurService professeurService;
    private final FiliereService filiereService;

    public DepartementController(DepartementService service, ProfesseurService professeurService, FiliereService filiereService) {
        this.service = service;
        this.professeurService = professeurService;
        this.filiereService = filiereService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Departement>> create(@RequestBody DepartementCreateDto departementCreateDto) {
        Professeur professeur = null;
        Departement departement;
        Filiere filiere;

        //check if user is not null and verify is already exist
        if(departementCreateDto.getProfesseurId() != null){
            try{
                professeur =  professeurService.getById(departementCreateDto.getProfesseurId());
            } catch (Throwable e) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(e.getMessage()));
            }
        }

        //verify  filiere exist
        try{
            filiere =  filiereService.getById(departementCreateDto.getFiliereId());
        } catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try {

            departement = service.save(
                    new Departement(
                            filiere.getName(),
                            filiere.getSigle(),
                            professeur,
                            filiere
                    )
            );


        }catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }



        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Departement created successfully", departement));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Departement>>> getAll() {
        List<Departement> countries = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Departement retrieved successfully", countries));
    }
}
