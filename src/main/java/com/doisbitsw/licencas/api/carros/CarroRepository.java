package com.doisbitsw.licencas.api.carros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    @Query(value = " SELECT car.*,user.nome as teste FROM carro car\n" +
            "INNER JOIN user  ON user.id = car.tipo", nativeQuery = true)
    List<Carro> findByTipo(String tipo);
}
