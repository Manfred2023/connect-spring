package net.campus.connect.controller;

import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.GroupeType;
import net.campus.connect.service.GroupeTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/groupe-types")
public class GroupeTypeController {

    private final GroupeTypeService service;

    public GroupeTypeController(GroupeTypeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<GroupeType>> create(@RequestBody GroupeType groupeType) {
        GroupeType saved = service.create(groupeType);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("GroupeType created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GroupeType>>> getAll() {
        List<GroupeType> list = service.getAll();
        return ResponseEntity.ok(ApiResponse.ok("GroupeTypes retrieved successfully", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GroupeType>> getById(@PathVariable Integer id) {
        GroupeType groupeType = service.getById(id);
        return ResponseEntity.ok(ApiResponse.ok("GroupeType retrieved successfully", groupeType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<GroupeType>> update(
            @PathVariable Integer id,
            @RequestBody GroupeType groupeType
    ) {
        GroupeType updated = service.update(id, groupeType);
        return ResponseEntity.ok(ApiResponse.ok("GroupeType updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("GroupeType deleted successfully", null));
    }
}