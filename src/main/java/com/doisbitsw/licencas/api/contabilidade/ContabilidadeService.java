package com.doisbitsw.licencas.api.contabilidade;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContabilidadeService {

    @Autowired

    private ContabilidadeRepository rep;
    public List<ContabilidadeDTO> getCarros() {
        List<ContabilidadeDTO> list = rep.findAll().stream().map(ContabilidadeDTO::create).collect(Collectors.toList());
        return list;
    }


    public ContabilidadeDTO getCarroById(Long id) {
        Optional<Contabilidade> carro = rep.findById(id);
        return carro.map(ContabilidadeDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }


    public List<ContabilidadeDTO> getCod(Long code, Long nivel) {
        return rep.findCod(code,nivel).stream().map(ContabilidadeDTO::create).collect(Collectors.toList());
    }

    public List<ContabilidadeDTO> getNivel(Long nivel) {
        return rep.findNivel(nivel).stream().map(ContabilidadeDTO::create).collect(Collectors.toList());
    }

    public List<ContabilidadeDTO> getId(Long id) {
        return rep.findId(id).stream().map(ContabilidadeDTO::create).collect(Collectors.toList());
    }


    public ContabilidadeDTO insert(Contabilidade contabilidade) {
        Assert.isNull(contabilidade.getId(),"Não foi possível inserir o registro");
        return ContabilidadeDTO.create(rep.save(contabilidade));
    }

    public ContabilidadeDTO update(Contabilidade contabilidade, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Contabilidade> optional = rep.findById(id);
        if(optional.isPresent()) {
            Contabilidade db = optional.get();
            // Copiar as propriedades
            db.setCod(contabilidade.getCod());
            db.setElemento(contabilidade.getElemento());
            db.setNomeOrgao(contabilidade.getNomeOrgao());
            db.setNomeUnidade(contabilidade.getNomeUnidade());
            db.setNomeProjeto(contabilidade.getNomeProjeto());
            db.setOrgao(contabilidade.getOrgao());
            db.setProjeto(contabilidade.getProjeto());
            db.setUnidade(contabilidade.getUnidade());
            db.setOrcamento(contabilidade.getOrcamento());

            System.out.println("Af id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return ContabilidadeDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }


    public void delete(Long id) {
        rep.deleteById(id);
    }


}
