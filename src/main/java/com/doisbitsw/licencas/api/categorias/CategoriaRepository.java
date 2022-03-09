package com.doisbitsw.licencas.api.categorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT * FROM categoria WHERE isativo = TRUE ;", nativeQuery = true)
    List<Categoria> findAtivo();

    @Query(value = "SELECT *  FROM categoria WHERE id = :id ", nativeQuery = true)
    List<Categoria> findId(Long id);


}
