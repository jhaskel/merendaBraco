package com.doisbitsw.licencas.api.cart;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long escola;
    private Long produto;
    private Long idestoque;
    private Long categoria;
    private Long licitacao;
    private Long fornecedor;
    private String unidade;
    private String processo;
    private Long cod;
    private String alias;
    private Double quantidade;
    private Double valor;
    private Double total;
    private String createdAt;
    private Boolean isagro;
    private String nomeescola;
    private String nomefornecedor;

}

