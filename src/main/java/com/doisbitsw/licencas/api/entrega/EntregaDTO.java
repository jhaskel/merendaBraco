package com.doisbitsw.licencas.api.entrega;


import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class EntregaDTO {
    private Long id;
    private Long ordem;
    private Long pedido;
    private Long escola;
    private String dia;
    private String nomeescola;
    private Long produto;
    private Long categoria;
    private Long licitacao;
    private String alias;
    private Double valor;
    private String unidade;
    private String fornecedor;
    private Double quantidade;
    private Boolean isrecebido;


    public static EntregaDTO create(Entrega entrega) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entrega, EntregaDTO.class);
    }
}
