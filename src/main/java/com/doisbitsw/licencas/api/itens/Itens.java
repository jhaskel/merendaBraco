package com.doisbitsw.licencas.api.itens;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Itens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long setor;
    private Long escola;
    private Long produto;
    private Long idestoque;
    private Long cod;
    private String alias;
    private Long categoria;
    private Long fornecedor;
    private Long nivel;
    private String unidade;
    private Long ano;
    private Long af;
    private Long pedido;
    private String created;
    private String nomeescola;
    private String nomenivel;
    private String processo;
    private Double quantidade;
    private Double valor;
    private Double total;
    private Boolean ischeck;
    private Boolean isagro;
    private String status;
    private String mes;
    private Boolean isativo;
    private Long licitacao;
    private String obs;

    //nao no banco
    private Double tot;
    private String nomec;




}

