package com.waltermilcoff.newsapi.domain;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private LocalDate publishedAt;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Source source;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Article() {
    }

    public Article(String title, String description, String url, String urlToImage,
                   LocalDate publishedAt, String content, Source source, Author author) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.source = source;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(description, article.description) && Objects.equals(url, article.url) && Objects.equals(urlToImage, article.urlToImage) && Objects.equals(publishedAt, article.publishedAt) && Objects.equals(content, article.content) && Objects.equals(source, article.source) && Objects.equals(author, article.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, url, urlToImage, publishedAt, content, source, author);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt=" + publishedAt +
                ", content='" + content + '\'' +
                ", source=" + source +
                ", author=" + author +
                '}';
    }
}
