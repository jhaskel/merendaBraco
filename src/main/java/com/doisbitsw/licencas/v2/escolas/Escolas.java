package com.doisbitsw.licencas.v2.escolas;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity(name = "unidade_escolar")
public class Escolas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nivelescolar;
    private String nome;
    private String alias;
    private String endereco;
    private String bairro;
    private Long alunos;
    private Boolean ativo;
    private String created;
    private String modified;

}

