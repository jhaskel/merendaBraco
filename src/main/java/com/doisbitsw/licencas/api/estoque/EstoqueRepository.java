package com.doisbitsw.licencas.api.estoque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {


    @Query(value = "SELECT est.*,SUM(ite.quantidade) AS comprado,cat.nome as nomecategoria,sub.alias as nomelicitacao\n" +
            "FROM estoque est\n" +
            "left JOIN itens ite ON ite.produto = est.produto\n" +
            "INNER JOIN categoria cat ON cat.id = est.categoria\n" +
            "INNER JOIN licitacao sub ON sub.id = est.licitacao\n" +
            "INNER JOIN fornecedor forn ON forn.id = est.fornecedor\n" +
            "where sub.isativo = true and cat.isativo = TRUE AND forn.isativo=true\n" +
            "GROUP BY est.produto\n" +
            "ORDER BY est.isativo DESC,est.categoria,est.alias", nativeQuery = true)
    List<Estoque> findAll();


    @Query(value = "SELECT * FROM estoque p \n" +
            "INNER JOIN categoria cat ON cat.id = p.categoria \n" +
            "WHERE p.isativo = TRUE AND cat.isativo = true and p.id NOT IN (SELECT produto FROM itens ite\n" +
            "INNER JOIN pedido ped ON ped.id = ite.pedido WHERE ite.escola = :local AND ped.isaf = TRUE) \n" +
            "ORDER BY p.isativo,p.categoria,p.agrofamiliar,p.alias ", nativeQuery = true)
    List<Estoque> findByEcola(Long local);


    @Query(value = "SELECT est.*,SUM(ite.quantidade) AS comprado,cat.nome as nomecategoria,forn.alias as nomelicitacao\n" +
            "FROM estoque est\n" +
            "left JOIN itens ite ON ite.idestoque = est.id\n" +
            "INNER JOIN categoria cat ON cat.id = est.categoria\n" +
            "INNER JOIN licitacao sub ON sub.id = est.licitacao\n" +
            "INNER JOIN fornecedor forn ON forn.id = est.fornecedor\n" +
            "WHERE est.setor = :setor and sub.isativo = true  and cat.isativo = true AND forn.isativo=true AND est.isativo = true\n" +
            "GROUP BY est.id\n" +
            "ORDER BY est.isativo DESC,est.categoria,est.alias", nativeQuery = true)
    List<Estoque> findEstoqueByUnidade(Long setor);

    @Query(value = "SELECT est.*,SUM(ite.quantidade) AS comprado,cat.nome as nomecategoria,forn.alias as nomelicitacao\n" +
            "FROM estoque est\n" +
            "left JOIN itens ite ON ite.produto = est.produto\n" +
            "INNER JOIN categoria cat ON cat.id = est.categoria\n" +
            "INNER JOIN licitacao lic ON lic.id = est.licitacao\n" +
            "INNER JOIN fornecedor forn ON forn.id = est.fornecedor\n" +
            "WHERE est.setor = 1 and  cat.isativo = true AND forn.isativo=TRUE AND est.licitacao=:licitacao\n" +
            "GROUP BY est.id\n" +
            "ORDER BY est.isativo DESC,est.categoria,est.alias", nativeQuery = true)
    List<Estoque> findLicitacao(Long licitacao);

    @Query(value = "SELECT est.*,SUM(ite.quantidade) AS comprado,ite.unidade as nomecategoria,ite.unidade as nomelicitacao\n" +
            "FROM estoque est\n" +
            "left JOIN itens ite ON ite.idestoque = est.id\n" +
            "INNER JOIN licitacao lic ON lic.id = est.licitacao\n" +
            "WHERE est.fornecedor=:fornecedor AND lic.isativo = TRUE\n" +
            "GROUP BY est.id", nativeQuery = true)
    List<Estoque> findFornecedor(Long fornecedor);


    @Query(value = "SELECT *,SUM(p.quantidade) AS comprado,p.unidade as nomecategoria,p.unidade as nomelicitacao \n" +
            "FROM estoque p\n" +
            "INNER JOIN licitacao lic ON lic.id = p.licitacao\n" +
            "WHERE p.isativo = true and lic.isativo = true and p.id NOT IN (SELECT produto FROM itens)\n" +
            "GROUP BY p.id \n" +
            "ORDER BY p.licitacao,p.categoria,p.alias", nativeQuery = true)
    List<Estoque> findMenos();

    @Query(value = "select * from estoque  where id = :id", nativeQuery = true)
    List<Estoque> findId(Long id);
}
