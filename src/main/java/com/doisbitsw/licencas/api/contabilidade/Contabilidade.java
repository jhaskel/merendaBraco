package com.doisbitsw.licencas.api.contabilidade;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Contabilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orgao;
    private String nomeOrgao;
    private Long unidade;
    private String nomeUnidade;
    private Long projeto;
    private String nomeProjeto;
    private String nomeReceita;
    private Long cod;
    private Long code;
    private String elemento;
    private Long nivel;
    private Double orcamento;

}

