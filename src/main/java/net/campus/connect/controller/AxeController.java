package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.Axe;
import net.campus.connect.model.City;
import net.campus.connect.service.AxeService;
import net.campus.connect.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/axe")
public class AxeController {
    private final AxeService service;

    public AxeController(AxeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Axe>> create(@RequestBody Axe axe) {
        Axe saved = service.save(axe);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Axe created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Axe>>> getAll() {
        List<Axe> axes = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("Axes retrieved successfully", axes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Axe>> getById(@PathVariable Integer id) {
        Axe axe = service.getById(id);
        return ResponseEntity.ok(ApiResponse.ok("City retrieved successfully", axe));
    }

    @GetMapping("/filiere/{filiereId}")
    public ResponseEntity<ApiResponse<List<Axe>>> getByCountry(@PathVariable Integer filiereId) {
        List<Axe> cities = service.getByFiliere(filiereId);
        return ResponseEntity.ok(ApiResponse.ok("Cities retrieved successfully", cities));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("City deleted successfully", null));
    }
}
