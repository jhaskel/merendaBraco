package com.doisbitsw.licencas.api.compras;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ComprasDTO {
    private Long id;
    private Long cod;
    private Long pedido;
    private Long escola;
    private Long setor;
    private Long nivel;
    private Long produto;
    private Long idestoque;
    private String alias;
    private String nomeescola;
    private String nomenivel;
    private String unidade;
    private Long ano;
    private Double quantidade;
    private Double valor;
    private Double total;
    private Long af;
    private String obs;
    private String created;
    private Long categoria;
    private Long fornecedor;
    private Boolean ischeck;
    private Boolean isagro;
    private String status;
    private String mes;
    private Boolean isativo;
    private Long licitacao;
    private String processo;

    private Double tot;


    public static ComprasDTO create(Compras compras) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(compras, ComprasDTO.class);
    }
}
