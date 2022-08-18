package com.waltermilcoff.newsapi.repository;

import com.waltermilcoff.newsapi.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByContentContaining(String content);

    List<Article> findByTitleContaining(String title);

    List<Article> findByDescriptionContaining(String palabra);

    List<Article> findByTitleContainingAndDescriptionContaining(String title, String description);
}
