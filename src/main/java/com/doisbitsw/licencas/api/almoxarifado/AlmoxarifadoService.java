package com.doisbitsw.licencas.api.almoxarifado;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlmoxarifadoService {

    @Autowired

    private AlmoxarifadoRepository rep;

    public List<AlmoxarifadoDTO> getCarros(Long licitacao) {
        List<AlmoxarifadoDTO> list = rep.findLicitacao(licitacao).stream().map(AlmoxarifadoDTO::create).collect(Collectors.toList());
        return list;
    }

    public List<AlmoxarifadoDTO> getEscola(Long escola) {
        List<AlmoxarifadoDTO> list = rep.findEscola(escola).stream().map(AlmoxarifadoDTO::create).collect(Collectors.toList());
        return list;
    }

    public List<AlmoxarifadoDTO> getTroca() {
        List<AlmoxarifadoDTO> list = rep.findTroca().stream().map(AlmoxarifadoDTO::create).collect(Collectors.toList());
        return list;
    }

    public AlmoxarifadoDTO getCarroById(Long id) {
        Optional<Almoxarifado> carro = rep.findById(id);
        return carro.map(AlmoxarifadoDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public AlmoxarifadoDTO insert(Almoxarifado pedidoAlmoxarifado) {
        Assert.isNull(pedidoAlmoxarifado.getId(),"Não foi possível inserir o registro");
        return AlmoxarifadoDTO.create(rep.save(pedidoAlmoxarifado));
    }

    public AlmoxarifadoDTO update(Almoxarifado almoxarifado, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Almoxarifado> optional = rep.findById(id);
        if(optional.isPresent()) {
            Almoxarifado db = optional.get();
            // Copiar as propriedades
            db.setEscola(almoxarifado.getEscola());
            db.setProduto(almoxarifado.getProduto());
            db.setCategoria(almoxarifado.getCategoria());
            db.setAlias(almoxarifado.getAlias());
            db.setCreated(almoxarifado.getCreated());
            db.setNomeescola(almoxarifado.getNomeescola());
            db.setUnidade(almoxarifado.getUnidade());
            db.setQuantidade(almoxarifado.getQuantidade());
            db.setIsativo(almoxarifado.getIsativo());
            db.setLicitacao(almoxarifado.getLicitacao());
            db.setObs(almoxarifado.getObs());
            db.setIstroca(almoxarifado.getIstroca());

            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return AlmoxarifadoDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
