package com.doisbitsw.licencas.api.almoxarifado;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AlmoxarifadoDTO {

    private Long id;
    private Long escola;
    private Long produto;
    private Long licitacao;
    private String alias;
    private Long categoria;
    private String unidade;
    private String created;
    private String obs;
    private String nomeescola;
    private Double quantidade;
    private Boolean isativo;
    private Boolean istroca;

    //não no banco
    private Long quant;


    public static AlmoxarifadoDTO create(Almoxarifado almoxarifado) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(almoxarifado, AlmoxarifadoDTO.class);
    }
}
