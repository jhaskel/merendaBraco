package com.doisbitsw.licencas.api.produtos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String alias;
    private String unidade;


    public static ProdutoDTO create(Produto produto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(produto, ProdutoDTO.class);
    }
}
