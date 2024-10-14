package com.example.checkpoint.repository;

import com.example.checkpoint.model.Diplomado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiplomadoRepository extends JpaRepository<Diplomado,Long> {
}
