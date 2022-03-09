package com.doisbitsw.licencas.api.almoxarifado;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Almoxarifado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long escola;
    private Long produto;
    private Long licitacao;
    private String alias;
    private Long categoria;
    private String unidade;
    private String created;
    private String nomeescola;
    private String obs;
    private Double quantidade;
    private Boolean isativo;
    private Boolean istroca;

    //não no banco
    private Long quant;






}

