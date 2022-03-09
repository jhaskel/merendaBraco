package com.doisbitsw.licencas.v2.caro;


import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CaroService{

    @Autowired
    private CaroRepository rep;

    public List<CaroDTO> getCarros() {
        List<CaroDTO> list = rep.findAll().stream().map(CaroDTO::create).collect(Collectors.toList());
        return list;
    }

    public CaroDTO getCarroById(Long id) {
        Optional<Caro> carro = rep.findById(id);
        return carro.map(CaroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<CaroDTO> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CaroDTO::create).collect(Collectors.toList());
    }

    public CaroDTO insert(Caro caro) {
        Assert.isNull(caro.getId(),"Não foi possível inserir o registro");

        return CaroDTO.create(rep.save(caro));
    }

    public CaroDTO update(Caro caro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Caro> optional = rep.findById(id);
        if(optional.isPresent()) {
            Caro db = optional.get();
            // Copiar as propriedades
            db.setNome(caro.getNome());
            db.setTipo(caro.getTipo());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return CaroDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}
