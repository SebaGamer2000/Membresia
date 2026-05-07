package com.Membresias.Membresias.Repository;

import com.Membresias.Membresias.Membresias.Membresias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresias, Long> {
}
