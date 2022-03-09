package com.doisbitsw.licencas.api.af.afAdd;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AfAddDTO {
    private Long id;
    private Long code;
    private Long setor;
    private Long nivel;
    private Long fornecedor;
    private String status;
    private Boolean isenviado;
    private String processo;
    private String createdAt;
    private Boolean isativo;
    private Long despesa;
    private Long coddespesa;
    private Long codedespesa;
    private Boolean isdespesa;
    private String empenho;
    private Long licitacao;



    public static AfAddDTO create(AfAdd afAdd) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(afAdd, AfAddDTO.class);
    }
}
