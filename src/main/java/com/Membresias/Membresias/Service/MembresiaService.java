package com.Membresias.Membresias.Service;

import com.Membresias.Membresias.Membresias.Membresias;
import com.Membresias.Membresias.Repository.MembresiaRepository;
import com.Membresias.Membresias.dto.MembresiaRequestDto;
import com.Membresias.Membresias.dto.MembresiaResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MembresiaService {

    private final MembresiaRepository membresiaRepository;

    private MembresiaResponseDTO maptoDTO(Membresias membresias){
        return new MembresiaResponseDTO(
                membresias.getIdMembresia(),
                membresias.getTipoPlan(),
                membresias.getBeneficio(),
                membresias.getPrecio()
        );
    }
    public List<MembresiaResponseDTO> findAll(){
        return membresiaRepository.findAll().stream().map(this::maptoDTO).collect(Collectors.toList());
    }

    public Optional<MembresiaResponseDTO> findById(Long idMembresia){
        return membresiaRepository.findById(idMembresia).map(this::maptoDTO);
    }

    public MembresiaResponseDTO guardar(MembresiaRequestDto dto){
        Membresias membresias = new Membresias(
                null,
                dto.getTipoPlan(),
                dto.getBeneficio(),
                dto.getPrecio()
        );
        return maptoDTO(membresiaRepository.save(membresias));
    }

    public Optional<MembresiaResponseDTO> actualizar(Long idMembresia, MembresiaRequestDto dto){
        return membresiaRepository.findById(idMembresia).map(existente ->{
            existente.setTipoPlan(dto.getTipoPlan());
            existente.setBeneficio(dto.getBeneficio());
            existente.setPrecio(dto.getPrecio());
            return maptoDTO(membresiaRepository.save(existente));
        });
    }
    public void eliminar(Long idMembresia){membresiaRepository.deleteById(idMembresia);}

}
