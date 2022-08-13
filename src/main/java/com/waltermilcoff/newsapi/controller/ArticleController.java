package com.waltermilcoff.newsapi.controller;
import com.waltermilcoff.newsapi.domain.Article;
import com.waltermilcoff.newsapi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    private final ArticleRepository articleRepository;


    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

/*

    Forma Utilizada en el video de crear la API de Movie Fest

    @PostMapping("/article")
    public Article createArticle(@RequestBody Article article){
        return articleRepository.save(article);
    }
*/

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public Article createArticle(@RequestBody Article article){

       return articleRepository.save(article);
    }


    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public Article getArticlePorId(@PathVariable("id") Long id) {
        return articleRepository.findById(id).get();
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(articleRepository.findAll(), HttpStatus.OK);
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

}
