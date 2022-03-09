package com.doisbitsw.licencas.api.estoque;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EstoqueDTO {
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
    private Long fornecedor;
    private Boolean agrofamiliar;
    private String processo;
    private Double valor;
    private Long ano;
    private String createdAt;
    private Boolean isativo;
    private String modifiedAt;

    //join
    private Double comprado;
    private String nomecategoria;
    private String nomelicitacao;


    public static EstoqueDTO create(Estoque estoque) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(estoque, EstoqueDTO.class);
    }
}
