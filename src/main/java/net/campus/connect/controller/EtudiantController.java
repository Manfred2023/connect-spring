package net.campus.connect.controller;

import net.campus.connect.clientDto.StudentCreateDto;
import net.campus.connect.clientDto.StudentLogin;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.City;
import net.campus.connect.model.Etudiant;
import net.campus.connect.service.CityService;
import net.campus.connect.service.EtudiantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService service;
    private final CityService cityService;

    public EtudiantController(EtudiantService service, CityService cityService) {
        this.service = service;
        this.cityService = cityService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Etudiant>> create(@RequestBody StudentCreateDto studentCreateDto) {
        City city;
        Etudiant etudiant;

        try{
             city = cityService.getById(studentCreateDto.getCityId());
        }catch (Throwable e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }
        try{

            etudiant = service.save(new Etudiant(
                    null,
                    studentCreateDto.getNom(),
                    studentCreateDto.getPrenom(),
                    studentCreateDto.getEmail(),
                    studentCreateDto.getMobile(),
                    city,
                    studentCreateDto.getMatricul() ,
                    studentCreateDto.getMdp()
            ));
        } catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }

        System.out.println(etudiant.toString());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Etudiant créé avec succès",etudiant ));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Etudiant>> login(@RequestBody StudentLogin studentLogin) {
        Etudiant etudiant;

        try {
            etudiant = service.getByMatricule(studentLogin.getMatricule());
        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.error("Echec lors de l'authentification"));
        }
        if(!Objects.equals(etudiant.getMdp(), studentLogin.getMdp())){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.error("Echec lors de l'authentification"));
        }


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Connexion reussie",etudiant ));
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