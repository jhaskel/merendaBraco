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
    private String nomeproduto;
    private Double quantidade;
    private String unidade;
    private Long categoria;
    private Long licitacao;
    private Long processo;
    private Long fornecedor;
    private Boolean agrofamiliar;
    private Double valor;
    private Long ano;
    private String createdAt;
    private Boolean isativo;
    private String modifiedAt;




}

