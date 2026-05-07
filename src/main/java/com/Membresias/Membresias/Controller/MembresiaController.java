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

    @GetMapping
    public ResponseEntity<List<MembresiaResponseDTO>> findAll(){
        return ResponseEntity.ok(membresiaService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<MembresiaResponseDTO> findById(@PathVariable Long id){
        return membresiaService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MembresiaResponseDTO> crear(
            @Valid @RequestBody MembresiaRequestDto dto
            ){
        return ResponseEntity.status(201).body(membresiaService.guardar(dto));
    }
    @PutMapping("{id}")
    public ResponseEntity<MembresiaResponseDTO> actualizar(
            @PathVariable Long id, @Valid @RequestBody MembresiaRequestDto dto
    ){
        return membresiaService.actualizar(id, dto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (membresiaService.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        membresiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    }
