package com.doisbitsw.licencas.api.almoxarifado.AlmoxarifadoAd;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AlmoxarifadoAdDTO {

    private Long id;
    private Long escola;
    private Long produto;
    private Long licitacao;
    private String alias;
    private Long categoria;
    private String unidade;
    private String obs;
    private String created;
    private String nomeescola;
    private Double quantidade;
    private Boolean isativo;
    private Boolean istroca;




    public static AlmoxarifadoAdDTO create(AlmoxarifadoAd almoxarifadoAd) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(almoxarifadoAd, AlmoxarifadoAdDTO.class);
    }
}
