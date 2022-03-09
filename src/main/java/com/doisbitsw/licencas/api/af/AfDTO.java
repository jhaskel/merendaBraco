package com.doisbitsw.licencas.api.af;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AfDTO {
    private Long id;
    private Long code;
    private Long setor;
    private Long nivel;
    private Long fornecedor;
    private String status;
    private Boolean isenviado;
    private String createdAt;
    private Boolean isativo;
    private Long despesa;
    private Long coddespesa;
    private Long codedespesa;
    private Boolean isdespesa;
    private String processo;
    private String empenho;
    private Long licitacao;

    //não esta no banco
    private String nomefor;
    private Double tot;


    public static AfDTO create(Af af) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(af, AfDTO.class);
    }
}
