package com.doisbitsw.licencas.v2.escolas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/escolas")
public class EscolasController {
    @Autowired
    private EscolasService service;


    @GetMapping()
    public ResponseEntity get() {
        List<EscolasDTO> carros = service.getNivel();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        EscolasDTO carro = service.getNivelById(id);

        return ResponseEntity.ok(carro);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity getCarrosById(@PathVariable("id") Long id) {
        List<EscolasDTO> carros = service.getCarrosById(id);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }
    @GetMapping("/quantidade")
    public long getQuantidade() {
        return service.getQuantidade();
    }

    @GetMapping("/quantAlunos")
    public long getQuantAlunos() {
        return service.getQuantAlunos();
    }

    @GetMapping("/quantAlunosNivel/{nivelescolar}")
    public long getQuantAlunosNivel(@PathVariable("nivelescolar") Long nivel) {
        return service.getQuantAlunosNivel(nivel);
    }

    @GetMapping("/quantAlunosEscola/{id}")
    public long getQuantAlunosEscola(@PathVariable("id") Long id) {
        return service.getQuantAlunosEscola(id);
    }

    @GetMapping("/quantEscolaNivel/{nivelescolar}")
    public long getQuantEscolaNivel(@PathVariable("nivelescolar") Long nivel) {
        return service.getQuantEscolaNivel(nivel);
    }

    @GetMapping("/nome/{id}")
    public String getNome(@PathVariable("id") Long id) {
        return service.getNome(id);
    }


    @PostMapping

    public ResponseEntity post(@RequestBody Escolas escolas) {

        EscolasDTO c = service.insert(escolas);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Escolas escolas) {

        escolas.setId(id);

        EscolasDTO c = service.update(escolas, id);

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
