package com.doisbitsw.licencas.api.contabilidade;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ContabilidadeDTO {
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



    public static ContabilidadeDTO create(Contabilidade contabilidade) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(contabilidade, ContabilidadeDTO.class);
    }
}
