package net.campus.connect.controller;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.SalleType;
import net.campus.connect.service.TypeSalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/type-salle")
public class TypeSalleController {

    private final TypeSalleService service;

    public TypeSalleController(TypeSalleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SalleType>> create(@RequestBody SalleType typeSalle) {
        SalleType saved = service.save(typeSalle);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("TypeSalle created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SalleType>>> getAll() {
        List<SalleType> typeSalles = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("TypeSalle retrieved successfully", typeSalles));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SalleType>> getById(@PathVariable Integer id) {
        SalleType typeSalle = service.getById(id);
        return ResponseEntity.ok(ApiResponse.ok("TypeSalle retrieved successfully", typeSalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("TypeSalle deleted successfully", null));
    }
}
