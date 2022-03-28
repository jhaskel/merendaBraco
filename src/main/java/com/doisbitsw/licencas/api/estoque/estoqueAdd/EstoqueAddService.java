package com.doisbitsw.licencas.api.estoque.estoqueAdd;

import com.doisbitsw.licencas.api.infra.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstoqueAddService {

    @Autowired

    private EstoqueAddRepository rep;


    public EstoqueAddDTO insert(EstoqueAdd estoqueAdd) {
        Assert.isNull(estoqueAdd.getId(),"Não foi possível inserir o registro");
        return EstoqueAddDTO.create(rep.save(estoqueAdd));
    }

    public EstoqueAddDTO update(EstoqueAdd estoqueAdd, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o produto no banco de dados
        Optional<EstoqueAdd> optional = rep.findById(id);
        if(optional.isPresent()) {
            EstoqueAdd db = optional.get();
            // Copiar as propriedades
            db.setCode(estoqueAdd.getCode());
            db.setAlias(estoqueAdd.getAlias());
            db.setAlias(estoqueAdd.getAlias());
            db.setUnidade(estoqueAdd.getUnidade());
            db.setCategoria(estoqueAdd.getCategoria());
            db.setFornecedor(estoqueAdd.getFornecedor());
            db.setQuantidade(estoqueAdd.getQuantidade());
            db.setLicitacao(estoqueAdd.getLicitacao());
            db.setProcesso(estoqueAdd.getProcesso());
            db.setAgrofamiliar(estoqueAdd.getAgrofamiliar());
            db.setAno(estoqueAdd.getAno());
            db.setModifiedAt(estoqueAdd.getModifiedAt());
            db.setIsativo(estoqueAdd.getIsativo());
            db.setValor(estoqueAdd.getValor());
            db.setNomeproduto(estoqueAdd.getNomeproduto());


            System.out.println("Produto id " + db.getId());

            // Atualiza o produto
            rep.save(db);

            return EstoqueAddDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }


}
