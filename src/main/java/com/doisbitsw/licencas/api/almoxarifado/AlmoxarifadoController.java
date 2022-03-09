package com.doisbitsw.licencas.api.almoxarifado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/almoxarifado")
public class AlmoxarifadoController {
    @Autowired
    private AlmoxarifadoService service;


    @GetMapping("licitacao/{licitacao}")
    public ResponseEntity getLicitacao(@PathVariable("licitacao") Long licitacao) {
        List<AlmoxarifadoDTO> carros = service.getCarros(licitacao);
        return ResponseEntity.ok(carros);
    }

    @GetMapping("escola/{escola}")
    public ResponseEntity getEscola(@PathVariable("escola") Long escola) {
        List<AlmoxarifadoDTO> carros = service.getEscola(escola);
        return ResponseEntity.ok(carros);
    }

    @GetMapping("troca")
    public ResponseEntity getTroca() {
        List<AlmoxarifadoDTO> carros = service.getTroca();
        return ResponseEntity.ok(carros);
    }


    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        AlmoxarifadoDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Almoxarifado pedidoAlmoxarifado) {

        AlmoxarifadoDTO c = service.insert(pedidoAlmoxarifado);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Almoxarifado pedidoAlmoxarifado) {
        pedidoAlmoxarifado.setId(id);
        AlmoxarifadoDTO c = service.update(pedidoAlmoxarifado, id);
        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
