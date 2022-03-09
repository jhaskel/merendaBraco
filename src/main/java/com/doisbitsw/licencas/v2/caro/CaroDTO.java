package com.doisbitsw.licencas.v2.caro;


import lombok.*;
import org.modelmapper.ModelMapper;

@Data
public class CaroDTO {
    private Long id;
    private String nome;
    private String tipo;


    public static CaroDTO create(Caro caro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(caro, CaroDTO.class);
    }
}
