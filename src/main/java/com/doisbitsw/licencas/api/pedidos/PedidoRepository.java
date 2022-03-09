package com.doisbitsw.licencas.api.pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query(value = "SELECT ped.*,uni.alias as nomedaescola,seto.id AS idsetor FROM pedido ped\n" +
            "INNER JOIN unidade_escolar uni ON uni.id = ped.escola\n" +
            "INNER JOIN setor seto ON seto.id = uni.setor\n" +
            "ORDER BY ped.isaf ,ped.id desc", nativeQuery = true)
    List<Pedido> findAll();



    @Query(value = "SELECT ped.*,esc.alias as nomedaescola,seto.id AS idsetor FROM pedido ped\n" +
            "INNER JOIN unidade_escolar esc ON esc.id = ped.escola\n" +
            "INNER JOIN setor seto ON seto.id = esc.setor\n" +
            " WHERE ped.escola = :escola\n" +
            " ORDER BY ped.id desc", nativeQuery = true)
    List<Pedido> findByUnidade(Long escola);

    @Query(value = "SELECT ped.*,esc.alias as nomedaescola,seto.id AS idsetor FROM pedido ped\n" +
            "INNER JOIN unidade_escolar esc ON esc.id = ped.escola\n" +
            "INNER JOIN setor seto ON seto.id = esc.setor\n" +
            "where ped.ischeck =:ischeck \n" +
            "order by ped.id DESC", nativeQuery = true)
    List<Pedido> findCheck(Boolean ischeck);

    @Query(value = "SELECT COUNT(id) AS totalCart FROM pedido where isaf = false", nativeQuery = true)
    long findPedidoSemAf();

    @Query(value = "SELECT * FROM pedido WHERE id = :id ;", nativeQuery = true)
    List<Pedido> findId(Long id);

}
