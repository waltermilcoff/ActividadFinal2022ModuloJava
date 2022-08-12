package com.waltermilcoff.newsapi.controller;

import com.waltermilcoff.newsapi.domain.Author;
import com.waltermilcoff.newsapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {


    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    /*
    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);

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

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public Author getAuthorPorId(@PathVariable("id") Long id) {
        return authorRepository.findById(id).get();
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(authorRepository.findAll(), HttpStatus.OK);}

}
