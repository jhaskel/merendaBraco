package com.doisbitsw.licencas.v2.escolas;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EscolasService {

    @Autowired

    private EscolasRepository rep;
    public List<EscolasDTO> getNivel() {
        List<EscolasDTO> list = rep.findAll().stream().map(EscolasDTO::create).collect(Collectors.toList());
        return list;
    }

    public EscolasDTO getNivelById(Long id) {
        Optional<Escolas> carro = rep.findById(id);
        return carro.map(EscolasDTO::create).orElseThrow(() -> new ObjectNotFoundException("Nivel não encontrado"));
    }


    public List<EscolasDTO> getCarrosById(Long id) {
        return rep.findCarroById(id).stream().map(EscolasDTO::create).collect(Collectors.toList());
    }

    public long getQuantidade(){ return rep.findQuantidade(); }

    public long getQuantAlunos(){ return rep.findQuantAlunos(); }

    public long getQuantAlunosNivel(Long nivel){ return rep.findQuantAlunosNivel(nivel); }

    public long getQuantAlunosEscola(Long id){ return rep.findQuantAlunosEscola(id); }

    public long getQuantEscolaNivel(Long nivel){ return rep.findQuantEscolaNivel(nivel); }


    public EscolasDTO insert(Escolas escolas) {
        Assert.isNull(escolas.getId(),"Não foi possível inserir o registro");
        return EscolasDTO.create(rep.save(escolas));
    }

    public String getNome(Long id){
        return rep.findNome(id);
    }


    public EscolasDTO update(Escolas escolas, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Escolas> optional = rep.findById(id);
        if(optional.isPresent()) {
            Escolas db = optional.get();
            // Copiar as propriedades
            db.setNivelescolar(escolas.getNivelescolar());
            db.setNome(escolas.getNome());
            db.setAlias(escolas.getAlias());
            db.setEndereco(escolas.getEndereco());
            db.setBairro(escolas.getBairro());
            db.setAlunos(escolas.getAlunos());
            db.setModified(escolas.getModified());
            db.setCreated(escolas.getCreated());
            db.setAtivo(escolas.getAtivo());
            System.out.println("Nivel id " + db.getId());
            // Atualiza o carro
            rep.save(db);

            return EscolasDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
