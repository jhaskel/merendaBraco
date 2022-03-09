package com.doisbitsw.licencas.api.almoxarifado.AlmoxarifadoAd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/almoxarifadoAd")
public class AlmoxarifadoAdController {
    @Autowired
    private AlmoxarifadoAdService service;




    @PostMapping
    public ResponseEntity post(@RequestBody AlmoxarifadoAd pedidoAlmoxarifadoAd) {

        AlmoxarifadoAdDTO c = service.insert(pedidoAlmoxarifadoAd);

        URI location = getUri(c.getId());
        return ResponseEntity.created(location).body(c);
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody AlmoxarifadoAd pedidoAlmoxarifadoAd) {
        pedidoAlmoxarifadoAd.setId(id);
        AlmoxarifadoAdDTO c = service.update(pedidoAlmoxarifadoAd, id);
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
