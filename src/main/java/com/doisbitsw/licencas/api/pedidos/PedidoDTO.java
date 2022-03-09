package com.doisbitsw.licencas.api.pedidos;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class PedidoDTO {
    private Long id;
    private Long escola;
    private Double total;
    private String status;
    private Boolean isaf;
    private String createdAt;
    private String modifiedAt;
    private Boolean isativo;
    private Boolean ischeck;
    private String user;
    private Long licitacao;

    private Long totalCart;
    private Long temCart;
    private String nomedaescola;
    private Long idsetor;



    public static PedidoDTO create(Pedido pedido) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pedido, PedidoDTO.class);
    }
}
