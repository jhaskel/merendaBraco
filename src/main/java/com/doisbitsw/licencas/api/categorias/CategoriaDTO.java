package com.doisbitsw.licencas.api.categorias;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CategoriaDTO {
    private Long id;
    private Long licitacao;
    private String nome;
    private Long icone;
    private Boolean isativo;
    private Boolean isalimento;



    public static CategoriaDTO create(Categoria categoria) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoria, CategoriaDTO.class);
    }
}
