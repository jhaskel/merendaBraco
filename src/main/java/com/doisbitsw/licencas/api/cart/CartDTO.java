package com.doisbitsw.licencas.api.cart;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CartDTO {
    private Long id;
    private Long escola;
    private Long produto;
    private Long idestoque;
    private Long fornecedor;
    private Long categoria;
    private Long licitacao;
    private String nomeescola;
    private String nomefornecedor;
    private String unidade;
    private String processo;
    private Long cod;
    private String alias;
    private Double quantidade;
    private Double valor;
    private Double total;
    private String createdAt;
    private Boolean isagro;

    public static CartDTO create(Cart cart) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cart, CartDTO.class);
    }
}
