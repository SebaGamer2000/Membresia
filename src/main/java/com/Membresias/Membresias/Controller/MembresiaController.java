package com.Membresias.Membresias.Controller;

import com.Membresias.Membresias.Service.MembresiaService;
import com.Membresias.Membresias.dto.MembresiaRequestDto;
import com.Membresias.Membresias.dto.MembresiaResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/membresias")
@RequiredArgsConstructor
public class MembresiaController {

    private final MembresiaService membresiaService;
    //GetMapping para listar todas las membresias
    @GetMapping
    public ResponseEntity<List<MembresiaResponseDTO>> findAll(){
        return ResponseEntity.ok(membresiaService.findAll());
    }
    //GetMapping para buscar una membresia por ID
    @GetMapping("{idMembresia}")
    public ResponseEntity<MembresiaResponseDTO> findById(@PathVariable Long idMembresia){
        return membresiaService.findById(idMembresia).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //PostMapping para crear y guardar una membresia
    @PostMapping
    public ResponseEntity<MembresiaResponseDTO> crear(
            @Valid @RequestBody MembresiaRequestDto dto
            ){
        return ResponseEntity.status(201).body(membresiaService.guardar(dto));
    }
    //PutMapping para actualizar una membresia
    @PutMapping("{idMembresia}")
    public ResponseEntity<MembresiaResponseDTO> actualizar(
            @PathVariable Long idMembresia, @Valid @RequestBody MembresiaRequestDto dto
    ){
        return membresiaService.actualizar(idMembresia, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    //DeleteMapping para eliminar una membresia usando su ID
    @DeleteMapping("{idMembresia}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idMembresia){
        if (membresiaService.findById(idMembresia).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        membresiaService.eliminar(idMembresia);
        return ResponseEntity.noContent().build();
    }
    }
