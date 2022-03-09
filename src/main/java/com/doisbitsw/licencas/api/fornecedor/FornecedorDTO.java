package com.doisbitsw.licencas.api.fornecedor;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class FornecedorDTO {
    private Long id;
    private String nome;
    private String alias;
    private String cnpj;
    private String email;
    private Boolean isativo;

    public static FornecedorDTO create(Fornecedor fornecedor) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(fornecedor, FornecedorDTO.class);
    }
}
