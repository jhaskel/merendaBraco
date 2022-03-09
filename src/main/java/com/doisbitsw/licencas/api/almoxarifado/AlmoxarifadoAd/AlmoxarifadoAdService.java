package com.doisbitsw.licencas.api.almoxarifado.AlmoxarifadoAd;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlmoxarifadoAdService {

    @Autowired

    private AlmoxarifadoAdRepository rep;





    public AlmoxarifadoAdDTO insert(AlmoxarifadoAd pedidoAlmoxarifadoAd) {
        Assert.isNull(pedidoAlmoxarifadoAd.getId(),"Não foi possível inserir o registro");
        return AlmoxarifadoAdDTO.create(rep.save(pedidoAlmoxarifadoAd));
    }

    public AlmoxarifadoAdDTO update(AlmoxarifadoAd almoxarifadoAd, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<AlmoxarifadoAd> optional = rep.findById(id);
        if(optional.isPresent()) {
            AlmoxarifadoAd db = optional.get();
            // Copiar as propriedades
            db.setEscola(almoxarifadoAd.getEscola());
            db.setProduto(almoxarifadoAd.getProduto());
            db.setCategoria(almoxarifadoAd.getCategoria());
            db.setAlias(almoxarifadoAd.getAlias());
            db.setCreated(almoxarifadoAd.getCreated());
            db.setNomeescola(almoxarifadoAd.getNomeescola());
            db.setUnidade(almoxarifadoAd.getUnidade());
            db.setQuantidade(almoxarifadoAd.getQuantidade());
            db.setIsativo(almoxarifadoAd.getIsativo());
            db.setLicitacao(almoxarifadoAd.getLicitacao());
            db.setObs(almoxarifadoAd.getObs());
            db.setIstroca(almoxarifadoAd.getIstroca());

            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return AlmoxarifadoAdDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
