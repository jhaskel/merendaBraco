package com.doisbitsw.licencas.api.contabilidade;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContabilidadeRepository extends JpaRepository<Contabilidade, Long> {
    @Query(value = "SELECT * FROM contabilidade where isativo = true ", nativeQuery = true)
    List<Contabilidade> findAll();

    @Query(value = "SELECT * FROM contabilidade WHERE id = :code and nivel = :nivel and isativo = true ", nativeQuery = true)
    List<Contabilidade> findCod(Long code,Long nivel);

    @Query(value = "SELECT * FROM contabilidade WHERE nivel = :nivel and isativo = true  ", nativeQuery = true)
    List<Contabilidade> findNivel(Long nivel);

    @Query(value = "SELECT * FROM contabilidade WHERE id = :id and isativo = true  ", nativeQuery = true)
    List<Contabilidade> findId(Long id);



}
