package com.waltermilcoff.newsapi.controller;

import com.waltermilcoff.newsapi.domain.Source;
import com.waltermilcoff.newsapi.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SourceController {

    @Autowired
    private final SourceRepository sourceRepository;

    @Autowired
    public SourceController(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    /*
    @PostMapping("/source")
    public Source createSource(@RequestBody Source source) {
        return sourceRepository.save(source);
    }
    -------------- Estraxto de RECETAS INFORMATORIO--------

    @RequestMapping(value = "/receta", method = RequestMethod.POST)
    public Receta createProducto(@RequestBody Receta receta) {
        return recetaRepository.save(receta);
    }

    @RequestMapping(value = "/receta/{id}", method = RequestMethod.GET)
    public Receta getRecetaPorId(@PathVariable("id") Long id) {
        return recetaRepository.findById(id).get();
    }

    @RequestMapping(value = "/receta", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(recetaRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/receta/{id}", method = RequestMethod.PUT)
    public Receta modificarProducto(@PathVariable("id") Long id, @RequestBody Receta receta) {
        Receta recetaExistente = recetaRepository.findById(id).get();
        recetaExistente.setDescription(receta.getDescription());
        return recetaRepository.save(recetaExistente);
    }

    @RequestMapping(value = "/receta/{id}", method = RequestMethod.DELETE)
    public void borrarPorId(@PathVariable("id") Long id) {
        recetaRepository.deleteById(id);
    }

    */

    @RequestMapping(value = "/source", method = RequestMethod.POST)
    public Source createSource(@RequestBody Source source) {
        return sourceRepository.save(source);
    }

}
