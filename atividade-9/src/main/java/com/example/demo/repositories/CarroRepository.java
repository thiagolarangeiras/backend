package com.example.demo.repositories;

import com.example.demo.models.Carro;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@Repository
public interface CarroRepository extends JpaRepository<Carro, UUID> {
    Page<Carro> findByNomeContaining(String nome, Pageable pageable);
}
