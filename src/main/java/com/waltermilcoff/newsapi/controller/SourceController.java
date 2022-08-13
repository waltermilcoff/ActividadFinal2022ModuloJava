package com.waltermilcoff.newsapi.controller;

import com.waltermilcoff.newsapi.domain.Source;
import com.waltermilcoff.newsapi.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SourceController {


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
    */

    @RequestMapping(value = "/source", method = RequestMethod.POST)
    public Source createSource(@RequestBody Source source) {
        return sourceRepository.save(source);
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

    @RequestMapping(value = "/source/{id}", method = RequestMethod.DELETE)
    public void borrarSourcePorId(@PathVariable("id") Long id) {
        sourceRepository.deleteById(id);
    }

}