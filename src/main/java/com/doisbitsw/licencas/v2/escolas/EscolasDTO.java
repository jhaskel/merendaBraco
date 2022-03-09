package com.doisbitsw.licencas.v2.escolas;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EscolasDTO {
    private Long id;
    private Long nivelescolar;
    private String nome;
    private String alias;
    private String endereco;
    private String bairro;
    private Long alunos;
    private Boolean ativo;
    private String created;
    private String modified;

    private Double quant;

    public static EscolasDTO create(Escolas escolas) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(escolas, EscolasDTO.class);
    }
}
