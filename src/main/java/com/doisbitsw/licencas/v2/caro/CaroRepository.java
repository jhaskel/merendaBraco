package com.doisbitsw.licencas.v2.caro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaroRepository extends JpaRepository<Caro, Long> {

    List<Caro> findByTipo(String tipo);
}
