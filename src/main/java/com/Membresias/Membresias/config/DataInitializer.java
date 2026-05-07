package com.Membresias.Membresias.config;

import com.Membresias.Membresias.Membresias.Membresias;
import com.Membresias.Membresias.Repository.MembresiaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final MembresiaRepository membresiaRepository;

    @Override
    public void run(String... args){
        if(membresiaRepository.count() > 0){
            log.info("Datos cargados");
            return;
        }

        log.info("No hay datos guardados, creando datos");

        membresiaRepository.save(
                new Membresias(null, "Mensual", "Acceso mensual", 10990)
        );

        membresiaRepository.save(
                new Membresias(null, "Trimestral", "Acceso por 3 meses", 29990)
        );

        membresiaRepository.save(
                new Membresias(null, "Anual", "Acceso completo anual", 99990)
        );
    }
}
