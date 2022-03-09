package com.doisbitsw.licencas.api.entrega;



import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntregaService {

    @Autowired

    private EntregaRepository rep;
    public List<EntregaDTO> getCardapio() {
        List<EntregaDTO> list = rep.findAll().stream().map(EntregaDTO::create).collect(Collectors.toList());
        return list;
    }

    public EntregaDTO getCardapioById(Long id) {
        Optional<Entrega> carro = rep.findById(id);
        return carro.map(EntregaDTO::create).orElseThrow(() -> new ObjectNotFoundException("Cardapio não encontrado"));
    }

    public List<EntregaDTO> getOrdem(Long ordem) {
        return rep.findOrdem(ordem).stream().map(EntregaDTO::create).collect(Collectors.toList());
    }

    public List<EntregaDTO> getPedido(Long pedido) {
        return rep.findPedido(pedido).stream().map(EntregaDTO::create).collect(Collectors.toList());
    }



    public EntregaDTO insert(Entrega entrega) {

        Assert.isNull(entrega.getId(),"Não foi possível inserir o registro");

        return EntregaDTO.create(rep.save(entrega));
    }


    public List<EntregaDTO> getFornecId(Long id) {
        return rep.findId(id).stream().map(EntregaDTO::create).collect(Collectors.toList());
    }

    public EntregaDTO update(Entrega entrega, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Entrega> optional = rep.findById(id);
        if(optional.isPresent()) {
            Entrega db = optional.get();
            // Copiar as propriedades


            db.setEscola(entrega.getEscola());
            db.setOrdem(entrega.getOrdem());
            db.setPedido(entrega.getPedido());
            db.setDia(entrega.getDia());
            db.setProduto(entrega.getProduto());
            db.setUnidade(entrega.getUnidade());
            db.setFornecedor(entrega.getFornecedor());
            db.setQuantidade(entrega.getQuantidade());
            db.setValor(entrega.getValor());
            db.setNomeescola(entrega.getNomeescola());
            db.setIsrecebido(entrega.getIsrecebido());
            db.setAlias(entrega.getAlias());
            db.setLicitacao(entrega.getLicitacao());
            db.setCategoria(entrega.getCategoria());
            System.out.println("Cardapio id " + db.getId());

            // Atualiza o cardapio
            rep.save(db);

            return EntregaDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
