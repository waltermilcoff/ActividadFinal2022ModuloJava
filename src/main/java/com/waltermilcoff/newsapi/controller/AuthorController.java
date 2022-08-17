package com.waltermilcoff.newsapi.controller;
import com.waltermilcoff.newsapi.domain.Author;
import com.waltermilcoff.newsapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Validated
public class AuthorController {

    @Autowired
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST)
    public Author createAuthor(@RequestBody Author author) {
        author.setFullname(generateFullname(author));
        return authorRepository.save(author);
    }

    private String generateFullname(Author author){
        return  author.getFirstname().concat(" ").concat(author.getLastname());
    }


    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public Author getAuthorPorId(@PathVariable("id") Long id) {
        return authorRepository.findById(id).get();
    }

    @RequestMapping(value = "/author", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(authorRepository.findAll(), HttpStatus.OK);}

    @RequestMapping(value = "/author/{id}", method = RequestMethod.PUT)
    public Author modificarAutor(@PathVariable("id") Long id, @RequestBody Author author) {
        Author autorExistente = authorRepository.findById(id).get();
        autorExistente.setFirstname(author.getFirstname());
        autorExistente.setLastname(author.getLastname());
        autorExistente.setCreatedAt(author.getCreatedAt());
        return authorRepository.save(autorExistente);
    }

   /*
   CONSULTA (OBTENER TODOS LOS USUARIOS QUE CONTENGAN UN STRING BUSCADO EN EL FULLNAME)
    */

    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public void borrarAutorPorId(@PathVariable("id") Long id) {
        authorRepository.deleteById(id);
    }

    /*
    CONSULTA (OBTENER TODOS LOS AUTORES QUE FUERON CREADOS LUEGO DE UNA FECHA DADA):
    */

}
