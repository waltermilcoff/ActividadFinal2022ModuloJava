package com.waltermilcoff.newsapi.controller;
import com.waltermilcoff.newsapi.converter.AuthorConverter;
import com.waltermilcoff.newsapi.domain.Author;
import com.waltermilcoff.newsapi.domain.Source;
import com.waltermilcoff.newsapi.dto.AuthorDTO;
import com.waltermilcoff.newsapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private AuthorConverter authorConverter;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
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
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Author> pageResult = authorRepository.findAll(pageable);
        return new ResponseEntity<>(pageResult, HttpStatus.OK);
       }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.PUT)
    public Author modificarAutor(@PathVariable("id") Long id, @RequestBody Author author) {
        Author autorExistente = authorRepository.findById(id).get();
        autorExistente.setFirstname(author.getFirstname());
        autorExistente.setLastname(author.getLastname());
        autorExistente.setCreatedAt(author.getCreatedAt());
        return authorRepository.save(autorExistente);
    }

    @RequestMapping(value = "/author/fullname/{palabras}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPalabras(@PathVariable("palabras") String palabras){
        List<Author> authorPalabras = authorRepository.findByFullnameContaining(palabras);
        return new ResponseEntity<>(authorPalabras, HttpStatus.OK);
    }


    @RequestMapping(value = "/author/{id}", method = RequestMethod.DELETE)
    public void borrarAutorPorId(@PathVariable("id") Long id) {
        authorRepository.deleteById(id);
    }

    /*
    CONSULTA (OBTENER TODOS LOS AUTORES QUE FUERON CREADOS LUEGO DE UNA FECHA DADA):

    Modelo en GitHub: spring-tutorials/myblog/src/main/java/com/informatorio/myblog/controller/UserController.java

    //GET Todos los user creados despues de cierta fecha
  @GetMapping // ~ /api/v1/post
  public ResponseEntity<?> buscarUsuariosCreadosDespuesDeFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    List<User> users = userRepository.findByCreationDateIsAfter(date);
    System.out.println("POR FIN ENTRO EN EL CONTROLLER!!!!!!");
    System.out.println(users.get(0).getNombre());
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

     */

   //Llevado a la Practica:

    @RequestMapping(value = "/author/fecha/{date}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarAutoresCreadosDespuesDeFecha(@PathVariable("date") LocalDate date) {
        List<Author> authorListDate = authorRepository.findByCreatedAtAfter(date);
        return new ResponseEntity<>(authorListDate, HttpStatus.OK);}

  /*
  Otra Forma que intento y no me funciona es medinate el DTO:

   @RequestMapping(value = "/author/fecha/{date}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarAutoresCreadosDespuesDeFecha(@PathVariable("date") LocalDate date)  {
        List<Author> author = authorRepository.findByCreatedAtAfter(date);
        List<AuthorDTO> authorDTOS = author.stream()
                .map(authorConverter::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(authorDTOS, HttpStatus.OK);
    */

    }

