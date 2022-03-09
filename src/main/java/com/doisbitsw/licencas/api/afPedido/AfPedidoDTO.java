package com.doisbitsw.licencas.api.afPedido;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class AfPedidoDTO {
    private Long id;
    private Long af;
    private Long setor;
    private Long pedido;
    private Double total;
    private Long nivel;
    private Long fornecedor;


    public static AfPedidoDTO create(AfPedido afPedido) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(afPedido, AfPedidoDTO.class);
    }
}
