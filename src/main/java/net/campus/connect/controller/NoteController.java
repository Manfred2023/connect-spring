package net.campus.connect.controller;


import net.campus.connect.clientDto.NoteCreateDto;
import net.campus.connect.dto.ApiResponse;
import net.campus.connect.model.*;
import net.campus.connect.service.InscriptionService;
import net.campus.connect.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;
    private final InscriptionService inscriptionService;

    public NoteController(NoteService noteService, InscriptionService inscriptionService) {
        this.noteService = noteService;
        this.inscriptionService = inscriptionService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Note>> create(@RequestBody NoteCreateDto noteCreateDto) {
        Inscription inscription;
        Note note;
        if(noteCreateDto.getValeur() > 20 || noteCreateDto.getValeur() < 0 ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error("La note ne doit etre comprise entre 0 et 20"));
        }
        if(noteCreateDto.getCoefficient() > 6 || noteCreateDto.getCoefficient() <= 0 ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error("La note ne doit etre comprise entre 1 et 6"));
        }
        try {
            inscription = inscriptionService.getById(noteCreateDto.getInscription_id());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        try {

            note = noteService.save(
                    new Note(null,noteCreateDto.getValeur(), noteCreateDto.getCoefficient(),inscription)
            );


        }catch (Throwable e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage()));
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.ok("Note created successfully", note));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Note>>> getAll() {
        List<Note> notes = noteService.getAll();
        return ResponseEntity.ok(ApiResponse.ok("notes retrieved successfully", notes));
    }
}
