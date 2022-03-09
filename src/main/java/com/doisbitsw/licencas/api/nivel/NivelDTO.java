package com.doisbitsw.licencas.api.nivel;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class NivelDTO {
    private Long id;
    private Long setor;
    private String nome;
    private Boolean isativo;
    private String created;
    private String modified;
    private Boolean isescola;

    public static NivelDTO create(Nivel nivel) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(nivel, NivelDTO.class);
    }
}
