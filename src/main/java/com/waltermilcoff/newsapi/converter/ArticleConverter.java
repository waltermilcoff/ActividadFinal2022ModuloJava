package com.waltermilcoff.newsapi.converter;

import com.waltermilcoff.newsapi.domain.Article;
import com.waltermilcoff.newsapi.dto.ArticleDTO;
import org.springframework.stereotype.Component;


@Component
public class ArticleConverter {
    public ArticleDTO toDTO(Article article){
        return new ArticleDTO(article.getId(), article.getTitle(), article.getDescription(),
                article.getUrl(), article.getUrlToImage(), article.getContent());
    }

}