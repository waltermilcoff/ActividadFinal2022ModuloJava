package com.waltermilcoff.newsapi.controller;
import com.waltermilcoff.newsapi.domain.Author;
import com.waltermilcoff.newsapi.domain.Source;
import com.waltermilcoff.newsapi.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SourceController {

    private final SourceRepository sourceRepository;

    @Autowired
    public SourceController(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @RequestMapping(value = "/source", method = RequestMethod.POST)
    public Source createSource(@RequestBody Source source) {
        source.setCode(generateCode(source));
        return sourceRepository.save(source);
    }
    private String generateCode(Source source){
        return source.getName().toLowerCase().replaceAll("[ ]", "-");

    }

    @RequestMapping(value = "/source/{id}", method = RequestMethod.GET)
    public Source getSourcePorId(@PathVariable("id") Long id) {
        return sourceRepository.findById(id).get();
    }

    @RequestMapping(value = "/source", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(sourceRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/source/{id}", method = RequestMethod.PUT)
    public Source modificarSource(@PathVariable("id") Long id, @RequestBody Source source) {
        Source sourceExistente = sourceRepository.findById(id).get();
        sourceExistente.setName(source.getName());
        sourceExistente.setCratedAt(source.getCratedAt());
        return sourceRepository.save(sourceExistente);
    }

    /*
    CONSULTA - OBTENER TODOS LOS SOURCES QUE CONTENGA UNA PALABRA DADA EN EL NOMBRE
     */
    @RequestMapping(value = "/source/name/{palabra}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPalabrasName(@PathVariable("palabra") String palabra){
        List<Source> source = sourceRepository.findByNameContaining(palabra);
        return new ResponseEntity(sourceRepository.findByNameContaining(palabra), HttpStatus.OK);}

    @RequestMapping(value = "/source/{id}", method = RequestMethod.DELETE)
    public void borrarSourcePorId(@PathVariable("id") Long id) {
        sourceRepository.deleteById(id);
    }

}