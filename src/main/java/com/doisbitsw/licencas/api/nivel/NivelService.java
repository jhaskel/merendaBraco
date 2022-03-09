package com.doisbitsw.licencas.api.nivel;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NivelService {

    @Autowired

    private NivelRepository rep;
    public List<NivelDTO> getCarros() {
        List<NivelDTO> list = rep.findAll().stream().map(NivelDTO::create).collect(Collectors.toList());
        return list;
    }

    public NivelDTO getCarroById(Long id) {
        Optional<Nivel> carro = rep.findById(id);
        return carro.map(NivelDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public String getRe(Long id){
        return rep.findNome(id);
    }

    public List<NivelDTO> getId(Long id) {
        return rep.findId(id).stream().map(NivelDTO::create).collect(Collectors.toList());
    }
    //verificado
    public List<NivelDTO> getSetor(Long setor) {
        return rep.findSetor(setor).stream().map(NivelDTO::create).collect(Collectors.toList());
    }


    public NivelDTO insert(Nivel nivel) {
        Assert.isNull(nivel.getId(),"Não foi possível inserir o registro");
        return NivelDTO.create(rep.save(nivel));
    }

    public NivelDTO update(Nivel nivel, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Nivel> optional = rep.findById(id);
        if(optional.isPresent()) {
            Nivel db = optional.get();
            // Copiar as propriedades
            db.setNome(nivel.getNome());
            db.setIsativo(nivel.getIsativo());
            db.setIsescola(nivel.getIsescola());
            System.out.println("Nivel id " + db.getId());
            rep.save(db);
            return NivelDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
