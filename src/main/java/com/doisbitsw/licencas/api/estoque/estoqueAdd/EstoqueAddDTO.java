package com.doisbitsw.licencas.api.estoque.estoqueAdd;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EstoqueAddDTO {
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



    public static EstoqueAddDTO create(EstoqueAdd estoqueAdd) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(estoqueAdd, EstoqueAddDTO.class);
    }
}
