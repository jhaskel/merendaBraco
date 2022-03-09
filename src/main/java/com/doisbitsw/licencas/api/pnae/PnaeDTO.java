package com.doisbitsw.licencas.api.pnae;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PnaeDTO {
    private Long id;
    private Double valor;
    private String created;
    private Long ano;
    private Long cidade;

    //
 //   private Double soma;

    public static PnaeDTO create(Pnae pnae) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pnae, PnaeDTO.class);
    }
}
