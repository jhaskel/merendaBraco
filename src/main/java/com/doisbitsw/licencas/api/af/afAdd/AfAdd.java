package com.doisbitsw.licencas.api.af.afAdd;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity(name = "af")
public class AfAdd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;
    private Long setor;
    private Long nivel;
    private Long fornecedor;
    private String status;
    private String empenho;
    private Boolean isenviado;
    private String createdAt;
    private String processo;
    private Boolean isativo;
    private Long despesa;
    private Long coddespesa;
    private Long codedespesa;
    private Boolean isdespesa;
    private Long licitacao;













}

