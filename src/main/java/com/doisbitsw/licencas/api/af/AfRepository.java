package com.doisbitsw.licencas.api.af;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AfRepository extends JpaRepository<Af, Long> {
    @Query(value = "SELECT af.*,SUM(ite.total) as tot,forn.alias as nomefor FROM af \n" +
            "INNER JOIN itens ite ON ite.af = af.code\n" +
            "INNER JOIN fornecedor forn ON forn.id = ite.fornecedor\n" +
            "GROUP BY af.code order by af.isenviado, af.id desc ", nativeQuery = true)
    List<Af> findAll2();

    @Query(value = "SELECT af.*,SUM(ite.total) as tot,forn.nome as nomefor FROM af \n" +
            "            INNER JOIN itens ite ON ite.af = af.code\n" +
            "            INNER JOIN fornecedor forn ON forn.id = ite.fornecedor\n" +
            "            WHERE forn.id = :fornecedor\n" +
            "            GROUP BY af.code order by af.isenviado, af.id desc", nativeQuery = true)
    List<Af> findByFornecedor(Long fornecedor);




    @Query(value = "SELECT af.*,SUM(ite.total) as tot,forn.nome as nomefor FROM af \n" +
            "INNER JOIN itens ite ON ite.af = af.code\n" +
            "INNER JOIN fornecedor forn ON forn.id = ite.fornecedor\n" +
            "WHERE  af.isdespesa = :isdespesa\n" +
            "GROUP BY af.code order by af.isenviado, af.id desc", nativeQuery = true)
    List<Af> findDespesa(Boolean isdespesa);

    @Query(value = "SELECT af.*,SUM(ite.total) as tot,forn.nome as nomefor FROM af \n" +
            "INNER JOIN itens ite ON ite.af = af.code\n" +
            "INNER JOIN fornecedor forn ON forn.id = ite.fornecedor\n" +
            "WHERE  af.status = :status\n" +
            "GROUP BY af.code order by af.isenviado, af.id desc", nativeQuery = true)
    List<Af> findStatus(String status);

    @Query(value = "SELECT af.*,SUM(ite.total) as tot,forn.alias as nomefor FROM af \n" +
            "INNER JOIN itens ite ON ite.af = af.code\n" +
            "INNER JOIN fornecedor forn ON forn.id = ite.fornecedor\n" +
            "WHERE ite.setor = :setor\n" +
            "GROUP BY af.code order by af.isenviado, af.id desc", nativeQuery = true)
    List<Af> findSetor(Long setor);

    @Query(value = "SELECT af.*,SUM(ite.total) as tot,forn.alias as nomefor FROM af \n" +
            "INNER JOIN itens ite ON ite.af = af.code\n" +
            "INNER JOIN fornecedor forn ON forn.id = ite.fornecedor\n" +
            "WHERE af.code = :code\n" +
            "GROUP BY af.code order by af.isenviado, af.id desc", nativeQuery = true)
    List<Af> findId(Long code);

    //somente para testes
    @Query(value = "SELECT * FROM af WHERE fornecedor = :fornecedor", nativeQuery = true)
    List<Af> findByFornecedorTest(Long fornecedor);

    @Query(value = "SELECT ite.* FROM itens ite\n" +
            "WHERE af = :af order by id desc", nativeQuery = true)
    List<Af> findByAf(Long af);

    @Query(value = "SELECT COUNT(id) as total FROM af WHERE isativo = TRUE AND isenviado = false", nativeQuery = true)
    long findAfEnviada();


}