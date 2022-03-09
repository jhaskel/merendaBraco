package com.doisbitsw.licencas.api.estoque.estoqueAdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/estoqueAdd")
public class EstoqueAddController {
    @Autowired
    private EstoqueAddService service;



    @PostMapping
    public ResponseEntity post(@RequestBody EstoqueAdd estoqueAdd) {
        EstoqueAddDTO c = service.insert(estoqueAdd);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody EstoqueAdd estoqueAdd) {

        estoqueAdd.setId(id);

        EstoqueAddDTO c = service.update(estoqueAdd, id);

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
