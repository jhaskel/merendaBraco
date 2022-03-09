package com.doisbitsw.licencas.api.contabilidade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contabilidade")
public class ContabilidadeController {
    @Autowired
    private ContabilidadeService service;


    @GetMapping()
    public ResponseEntity get() {
        List<ContabilidadeDTO> carros = service.getCarros();
        return ResponseEntity.ok(carros);
    }



    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        ContabilidadeDTO carro = service.getCarroById(id);

        return ResponseEntity.ok(carro);
    }

    @GetMapping("/cod/{code}/{nivel}")
    public ResponseEntity getCod(@PathVariable("code") Long code,@PathVariable("nivel") Long nivel) {
        List<ContabilidadeDTO> carros = service.getCod(code,nivel);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @GetMapping("/nivel/{nivel}")
    public ResponseEntity getNivel(@PathVariable("nivel") Long nivel) {
        List<ContabilidadeDTO> carros = service.getNivel(nivel);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity getId(@PathVariable("id") Long id) {
        List<ContabilidadeDTO> carros = service.getId(id);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }





    @PostMapping
    public ResponseEntity post(@RequestBody Contabilidade contabilidade) {

        ContabilidadeDTO c = service.insert(contabilidade);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Contabilidade contabilidade) {
        contabilidade.setId(id);
        ContabilidadeDTO c = service.update(contabilidade, id);
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
