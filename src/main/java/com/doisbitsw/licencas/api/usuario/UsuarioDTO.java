package com.doisbitsw.licencas.api.usuario;

import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class UsuarioDTO {
    private Long id;
    private Long setor;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private Long escola;
    private String nivel;
    private Boolean isativo;
    private String created;
    private String modified;



    public static UsuarioDTO create(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
