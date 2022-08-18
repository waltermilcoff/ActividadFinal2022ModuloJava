package com.waltermilcoff.newsapi.controller;
import com.waltermilcoff.newsapi.converter.ArticleConverter;
import com.waltermilcoff.newsapi.domain.Article;
import com.waltermilcoff.newsapi.dto.ArticleDTO;
import com.waltermilcoff.newsapi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArticleController {

    @Autowired
    private final ArticleRepository articleRepository;

    @Autowired
    private final ArticleConverter articleConverter;

    @Autowired
    public ArticleController(ArticleRepository articleRepository, ArticleConverter articleConverter) {

        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
    }

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public Article createArticle(@RequestBody Article article) {

        return articleRepository.save(article);
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public ResponseEntity<?> buscarArticulos() {
        List<Article> article = articleRepository.findAll();
        List<ArticleDTO> articleDTOS = article.stream()
                .map(articleConverter::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(articleDTOS, HttpStatus.OK);
    }

    @RequestMapping(value = "/article/paginado", method = RequestMethod.GET)
    public ResponseEntity<?> findByAll(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Article> pageResult = articleRepository.findAll(pageable);
        List<ArticleDTO> articleDTOS = pageResult.stream()
                .map(articleConverter::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(articleDTOS, HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT)
    public Article modificarArticulo(@PathVariable("id") Long id, @RequestBody Article article) {
        Article articuloExistente = articleRepository.findById(id).get();
        articuloExistente.setTitle(article.getTitle());
        articuloExistente.setDescription(article.getDescription());
        articuloExistente.setUrl(article.getUrl());
        articuloExistente.setUrlToImage(article.getUrlToImage());
        articuloExistente.setPublishedAt(article.getPublishedAt());
        articuloExistente.setContent(article.getContent());
        articuloExistente.setSource(article.getSource());
        articuloExistente.setAuthor(article.getAuthor());
        return articleRepository.save(articuloExistente);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
    public void borrarArticuloPorId(@PathVariable("id") Long id) {
        articleRepository.deleteById(id);
    }

    @RequestMapping(value = "/article/palabras/{description}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPalabras(@PathVariable("description") String palabra) {
        List<Article> articuloPorPalabras = articleRepository.findByDescriptionContaining(palabra);
        List<ArticleDTO> articleDTOSpalabras = articuloPorPalabras.stream()
                .map(articleConverter::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(articleDTOSpalabras, HttpStatus.OK);
    }
}
/*
    CONSULTA - OBTENER TODOS ARTICULOS (SEGUN UNA PALABRA BUSCADA).
    La palabra a buscar debe ser mayor a 3 caracteres
    Solo los articulos publicados se deben retornar
    LA QUERY DEBE BUSCAR SOBRE LOS CAMPOS (title, description)
    Opcional: La query anterior debe abarcar tambien content y el fullname del author

   Intento pero no funciona:
    @RequestMapping(value = "/article/palabras/titulo/{description}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarPalabrasEnTitulo(@PathVariable("description") String titulo, String descripcion) {
        List<Article> articuloPorPalabrasTitulo = articleRepository.findByTitleContainingAndDescriptionContaining(titulo, descripcion);
        List<ArticleDTO> articleDTOSpalabrasTitulo = articuloPorPalabrasTitulo.stream()
                .map(articleConverter::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(articleDTOSpalabrasTitulo, HttpStatus.OK);

     */






