package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Country;
import net.campus.connect.model.Salle;
import net.campus.connect.service.CountryService;
import net.campus.connect.service.SalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/salle")
public class SalleController {
    private final SalleService service;

    public SalleController(SalleService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Salle>> create(@RequestBody Salle salle) {
        Salle saved = service.save(salle);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Salle created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Salle>>> getAll() {
        List<Salle> salles = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Salle retrieved successfully", salles));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("City deleted successfully", null));
    }
}
