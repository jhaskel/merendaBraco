package com.doisbitsw.licencas.api.estoque.estoqueAdd;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity(name = "estoque")
public class EstoqueAdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produto;
    private Long setor;
    private Long code;
    private String alias;
    private Long fornecedor;
    private String nomeproduto;
    private Double quantidade;
    private Double valor;
    private String unidade;
    private String processo;
    private Long categoria;
    private Long licitacao;
    private Boolean agrofamiliar;
    private Long ano;
    private String createdAt;
    private Boolean isativo;
    private String modifiedAt;




}

