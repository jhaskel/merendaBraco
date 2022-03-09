package com.doisbitsw.licencas.api.almoxarifado;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long> {

    @Query(value = "SELECT alm.* ,SUM(alm.quantidade) AS quant\n" +
            "FROM almoxarifado alm\n" +
            "INNER JOIN categoria cat ON cat.id = alm.categoria\n" +
            "WHERE cat.isalimento=FALSE and alm.licitacao=:licitacao\n" +
            "group BY alm.escola,alm.produto\n" +
            "ORDER BY alm.produto\n", nativeQuery = true)
    List<Almoxarifado> findLicitacao(Long licitacao);


    @Query(value = "SELECT alm.* ,SUM(alm.quantidade) AS quant\n" +
            "FROM almoxarifado alm\n" +
            "INNER JOIN categoria cat ON cat.id = alm.categoria\n" +
            "WHERE cat.isalimento=FALSE and alm.escola=:escola\n" +
            "group BY alm.escola,alm.produto\n" +
            "ORDER BY alm.produto\n", nativeQuery = true)
    List<Almoxarifado> findEscola(Long escola);

    @Query(value = "SELECT alm.* ,SUM(alm.quantidade) AS quant\n" +
            "FROM almoxarifado alm\n" +
            "INNER JOIN categoria cat ON cat.id = alm.categoria\n" +
            "WHERE cat.isalimento=FALSE  AND alm.istroca = true\n" +
            "group BY alm.escola\n" +
            "ORDER BY alm.produto", nativeQuery = true)
    List<Almoxarifado> findTroca();


}

