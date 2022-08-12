package com.waltermilcoff.newsapi.controller;

import com.waltermilcoff.newsapi.domain.Article;
import com.waltermilcoff.newsapi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {


    private final ArticleRepository articleRepository;


    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

  /*
    @PostMapping("/article")
    public Article createArticle(@RequestBody Article article){
        return articleRepository.save(article);

    }

      -------------- Estraxto de RECETAS INFORMATORIO--------

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

   @RequestMapping(value = "/article", method = RequestMethod.POST)
    public Article createArticle(@RequestBody Article article){

       return articleRepository.save(article);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public Article getArticlePorId(@PathVariable("id") Integer id) {
        return articleRepository.findById(id).get();
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(articleRepository.findAll(), HttpStatus.OK);
    }
}
