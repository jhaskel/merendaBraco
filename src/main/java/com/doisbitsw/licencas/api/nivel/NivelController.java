package com.doisbitsw.licencas.api.nivel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/nivel")

public class NivelController {
    @Autowired
    private NivelService service;


    @GetMapping()
    public ResponseEntity get() {
        List<NivelDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        NivelDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping("/nome/{id}")
    public String getRe(@PathVariable("id") Long id) {
        return service.getRe(id);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getId(@PathVariable("id") Long id) {
        List<NivelDTO> carros = service.getId(id);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/setor/{setor}")
    public ResponseEntity getSetor(@PathVariable("setor") Long setor) {
        List<NivelDTO> itens = service.getSetor(setor);
        return itens.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(itens);
    }



    @PostMapping

    public ResponseEntity post(@RequestBody Nivel nivel) {
        NivelDTO c = service.insert(nivel);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Nivel nivel) {
        nivel.setId(id);
        NivelDTO c = service.update(nivel, id);
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
