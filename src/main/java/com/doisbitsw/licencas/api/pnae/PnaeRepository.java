package com.doisbitsw.licencas.api.pnae;

import com.doisbitsw.licencas.api.pedidos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PnaeRepository extends JpaRepository<Pnae, Long> {

    @Query(value = "SELECT * FROM pnae WHERE ano = 2021 order by id desc ", nativeQuery = true)
    List<Pnae> findAll(Long ano);

    @Query(value = "SELECT * FROM pnae WHERE ano = :ano ", nativeQuery = true)
    List<Pnae> findAno(Long ano);

    @Query(value = "SELECT sum(valor) as soma  FROM pnae \n" +
            "WHERE    ano = :ano ", nativeQuery = true)
    double findSoma(Long ano);

}
